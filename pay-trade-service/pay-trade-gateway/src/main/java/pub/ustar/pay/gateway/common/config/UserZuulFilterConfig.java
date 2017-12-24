package pub.ustar.pay.gateway.common.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import pub.ustar.pay.gateway.common.constant.PayTradeGatewayConstant;
import pub.ustar.pay.gateway.common.constant.ZuulFilterConstant;
import pub.ustar.pay.gateway.common.exception.PayTradeGatewayException;
import pub.ustar.pay.gateway.common.exception.PayTradeGatewayValidateSignException;
import pub.ustar.pay.gateway.common.util.TimestampUtils;
import pub.ustar.pay.gateway.service.TradeGatewaySignService;
import pub.ustar.pay.trade.common.model.pojo.TradeRequest;
import pub.ustar.pay.trade.common.model.pojo.TradeResponse;
import pub.ustar.pay.trade.common.util.JacksonUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 用户自定义Zuul过滤器
 */
@Configuration
public class UserZuulFilterConfig {


    private final static Logger LOGGER = LoggerFactory.getLogger(UserZuulFilterConfig.class);

    @Autowired
    private TradeGatewaySignService tradeGatewaySignService;


    @Bean
    public ZuulFilter requestJsonContentFilter() {
        return new RequestJsonContentFilter();
    }

    @Bean
    public ZuulFilter responseJsonContentFilter() {
        return new ResponseJsonContentFilter();
    }

    /**
     * application/json请求过滤器
     *
     * @author xy
     */

    public class RequestJsonContentFilter extends ZuulFilter {

        @Override
        public String filterType() {
            return ZuulFilterConstant.FILTER_TYPE_PRE;
        }

        @Override
        public int filterOrder() {
            return ZuulFilterConstant.FILTER_ORDER_REQUEST_CONTEXT_ORDER;
        }

        @Override
        public boolean shouldFilter() {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            String contentType = request.getContentType();
            if (MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object run() {
            RequestContext context = RequestContext.getCurrentContext();
            String gatewayResultCode = null;
            String gatewayResultMsg = null;
            try {
                HttpServletRequest httpServletRequest = context.getRequest();
                InputStream stream = httpServletRequest.getInputStream();
                String encoding = httpServletRequest.getCharacterEncoding();
                if (encoding == null || "".equals(encoding)) {
                    encoding = ZuulFilterConstant.FILTER_DEFAULT_ENCODING;
                }
                String body = StreamUtils.copyToString(stream, Charset.forName(encoding));
                LOGGER.info("request: {}", body);
                TradeRequest tradeRequest = JacksonUtils.jsonToBean(body, TradeRequest.class);

                String signType = tradeRequest.getSignType();
                String sign = tradeRequest.getSign();

                boolean isValidSign = tradeGatewaySignService.validateSign(tradeRequest);
                LOGGER.info("验签结果: {}", isValidSign);
                if (!isValidSign) {
                    throw new PayTradeGatewayValidateSignException();
                }
                Long timestamp = Long.parseLong(tradeRequest.getTimestamp());
                TimestampUtils.checkTimestamp(timestamp, 1000);
                gatewayResultCode = PayTradeGatewayConstant.GATEWAY_CODE_OK;
                LOGGER.info("tradeRequest: {}", tradeRequest);
            } catch (PayTradeGatewayException e) {
                gatewayResultCode = PayTradeGatewayConstant.GATEWAY_CODE_NO_PERMISSION;
                gatewayResultMsg = PayTradeGatewayConstant.GATEWAY_MSG_NO_PERMISSION;
            } catch (Exception e) {
                gatewayResultCode = PayTradeGatewayConstant.GATEWAY_CODE_UNKNOW_ERROR;
                gatewayResultMsg = PayTradeGatewayConstant.GATEWAY_MSG_UNKNOW_ERROR;
                e.printStackTrace();
            } finally {
                context.setResponseStatusCode(HttpStatus.SC_OK);
                context.getResponse().setContentType(MediaType.APPLICATION_JSON_VALUE);
                if (PayTradeGatewayConstant.GATEWAY_CODE_OK.equals(gatewayResultCode)) {
                    context.setSendZuulResponse(true);
                    context.set(ZuulFilterConstant.FILTER_REQUEST_FILTER_RESULT_KEY, ZuulFilterConstant.FILTER_REQUEST_FILTER_RESULT_VALUE_SUCCESS);
                } else {
                    context.setSendZuulResponse(false);
                    TradeResponse tradeResponse = new TradeResponse();
                    tradeResponse.setCode(gatewayResultCode);
                    tradeResponse.setMsg(gatewayResultMsg);
                    String response = JacksonUtils.beanToJson(tradeResponse);
                    context.setResponseBody(response);
                    context.set(ZuulFilterConstant.FILTER_REQUEST_FILTER_RESULT_KEY, ZuulFilterConstant.FILTER_REQUEST_FILTER_RESULT_VALUE_FAILURE);
                }
            }
            return null;
        }

    }


    /**
     * application/json响应过滤器
     *
     * @author xy
     */

    public class ResponseJsonContentFilter extends ZuulFilter {

        @Override
        public String filterType() {
            return ZuulFilterConstant.FILTER_TYPE_POST;
        }

        @Override
        public int filterOrder() {
            return ZuulFilterConstant.FILTER_ORDER_RESPONSE_CONTEXT_ORDER;
        }

        @Override
        public boolean shouldFilter() {
            RequestContext context = RequestContext.getCurrentContext();
            HttpServletRequest request = context.getRequest();
            String contentType = request.getContentType();

            String requestFilterResult = context.get(ZuulFilterConstant.FILTER_REQUEST_FILTER_RESULT_KEY).toString();

            if (ZuulFilterConstant.FILTER_REQUEST_FILTER_RESULT_VALUE_SUCCESS.equals(requestFilterResult)) {
                return true;
            } else if (ZuulFilterConstant.FILTER_REQUEST_FILTER_RESULT_VALUE_FAILURE.equals(requestFilterResult)) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Object run() {
            RequestContext context = RequestContext.getCurrentContext();
            try {
                InputStream inputStream = context.getResponseDataStream();
                HttpServletRequest httpServletRequest = context.getRequest();
                String encoding = httpServletRequest.getCharacterEncoding();
                if (encoding == null || "".equals(encoding)) {
                    encoding = ZuulFilterConstant.FILTER_DEFAULT_ENCODING;
                }

                String body = StreamUtils.copyToString(inputStream, Charset.forName(encoding));

                TradeResponse tradeResponse = new TradeResponse();
                tradeResponse.setCode(PayTradeGatewayConstant.GATEWAY_CODE_OK);
                tradeResponse.setMsg(PayTradeGatewayConstant.GATEWAY_MSG_OK);
                tradeResponse.setTimestamp(TimestampUtils.getTimestamp().toString());
                tradeResponse.setBizContent(body);
                tradeResponse.setSign(tradeGatewaySignService.generateSign(tradeResponse));

                String response = JacksonUtils.beanToJson(tradeResponse);
                context.setSendZuulResponse(true);
                context.setResponseBody(response);
            } catch (Exception e) {
                context.setSendZuulResponse(false);
                TradeResponse tradeResponse = new TradeResponse();
                tradeResponse.setCode(PayTradeGatewayConstant.GATEWAY_CODE_UNKNOW_ERROR);
                tradeResponse.setMsg(PayTradeGatewayConstant.GATEWAY_MSG_UNKNOW_ERROR);
                String response = JacksonUtils.beanToJson(tradeResponse);
                context.setResponseBody(response);
                e.printStackTrace();
            } finally {
                context.setResponseStatusCode(HttpStatus.SC_OK);
                context.getResponse().setContentType(MediaType.APPLICATION_JSON_VALUE);
            }
            return null;
        }

    }

}

package pub.ustar.pay.gateway.common.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import pub.ustar.pay.gateway.common.util.TimestampUtils;
import pub.ustar.pay.trade.common.model.pojo.TradeRequest;
import pub.ustar.pay.trade.common.util.JacksonUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;


/**
 * application/json请求过滤器
 *
 * @author xy
 */
public class RequestJsonContentFilter extends ZuulFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(RequestJsonContentFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
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
        try {
            HttpServletRequest httpServletRequest = context.getRequest();
            InputStream stream = httpServletRequest.getInputStream();
            String encoding = httpServletRequest.getCharacterEncoding();
            if (encoding == null || "".equals(encoding)) {
                encoding = "UTF-8";
            }
            String body = StreamUtils.copyToString(stream, Charset.forName(encoding));
            LOGGER.debug("request: {}", body);
            TradeRequest tradeRequest = JacksonUtils.jsonToBean(body, TradeRequest.class);

            String signType = tradeRequest.getSignType();
            String sign = tradeRequest.getSign();

            Long timestamp = Long.parseLong(tradeRequest.getTimestamp());
            TimestampUtils.checkTimestamp(timestamp, 1000);

            String method = tradeRequest.getMethod();
            String serviceUrl = "/api/trade/query";

            LOGGER.debug("tradeRequest: {}", tradeRequest);
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(HttpStatus.SC_OK);

            context.set(FilterConstants.REQUEST_URI_KEY, serviceUrl);


        } catch (IOException e) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return null;
    }
}

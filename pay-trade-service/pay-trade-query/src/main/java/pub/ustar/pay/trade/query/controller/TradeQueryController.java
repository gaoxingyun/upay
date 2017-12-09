package pub.ustar.pay.trade.query.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pub.ustar.pay.trade.common.model.pojo.TradeQueryRequest;
import pub.ustar.pay.trade.common.model.pojo.TradeQueryResponse;

@RefreshScope
@RestController
@RequestMapping("/api/trade")
public class TradeQueryController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TradeQueryRequest.class);

    @RequestMapping(method = RequestMethod.POST, value = "/query", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TradeQueryResponse query(@RequestBody TradeQueryRequest request)
    {

        LOGGER.debug("request:{}", request);

        TradeQueryResponse response = new TradeQueryResponse();
        response.setResultCode("200");
        return response;
    }
}

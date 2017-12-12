package pub.ustar.pay.gateway.service;

import org.springframework.stereotype.Service;
import pub.ustar.pay.trade.common.model.pojo.TradeRequest;
import pub.ustar.pay.trade.common.model.pojo.TradeResponse;

import java.util.Map;

/**
 * 网关签名服务
 *
 * @author xy
 */
@Service
public class TradeGatewaySignService {

    /**
     * 验签
     *
     * @param request
     * @return true 验签通过 false 验签不通过
     */
    public boolean validateSign(TradeRequest request) {
        String signType = request.getSignType();
        String sign = request.getSign();

        String appId = request.getAppId();
        String key = null;
        if ("1234567890".equals(request.getSign())) {
            return true;
        }
        return false;
    }


    /**
     * 生成签名
     *
     * @param response
     * @return 签名串
     * @throws RuntimeException 签名出错
     */
    public String generateSign(TradeResponse response) {
        return "1234567890";
    }
}

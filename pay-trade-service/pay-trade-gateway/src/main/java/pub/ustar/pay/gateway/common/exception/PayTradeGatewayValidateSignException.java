package pub.ustar.pay.gateway.common.exception;


/**
 * 支付网关自定义验签异常
 *
 * @author xy
 */
public class PayTradeGatewayValidateSignException extends PayTradeGatewayException {

    public PayTradeGatewayValidateSignException() {
    }

    public PayTradeGatewayValidateSignException(String message) {
        super(message);
    }

    public PayTradeGatewayValidateSignException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayTradeGatewayValidateSignException(Throwable cause) {
        super(cause);
    }

    public PayTradeGatewayValidateSignException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

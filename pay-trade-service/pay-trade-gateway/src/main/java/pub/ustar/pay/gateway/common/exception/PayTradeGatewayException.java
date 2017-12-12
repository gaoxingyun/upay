package pub.ustar.pay.gateway.common.exception;

/**
 * 支付网关自定义根异常
 *
 * @author xy
 */
public class PayTradeGatewayException extends RuntimeException {

    public PayTradeGatewayException() {
    }

    public PayTradeGatewayException(String message) {
        super(message);
    }

    public PayTradeGatewayException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayTradeGatewayException(Throwable cause) {
        super(cause);
    }

    public PayTradeGatewayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

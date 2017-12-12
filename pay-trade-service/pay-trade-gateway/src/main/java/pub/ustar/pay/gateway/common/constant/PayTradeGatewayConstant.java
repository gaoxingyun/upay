package pub.ustar.pay.gateway.common.constant;

/**
 * 网关返回码常量
 *
 * @author xy
 */
public class PayTradeGatewayConstant {

    // 成功
    public final static String GATEWAY_CODE_OK = "200";
    public final static String GATEWAY_MSG_OK = "ok";
    // 重试
    public final static String GATEWAY_CODE_RETRY = "202";
    public final static String GATEWAY_MSG_RETRY = "retry";
    // 缺少必要参数
    public final static String GATEWAY_CODE_MISS_PARAM = "400";
    public final static String GATEWAY_MSG_MISS_PARAM = "miss param";
    // 权限不足
    public final static String GATEWAY_CODE_NO_PERMISSION = "403";
    public final static String GATEWAY_MSG_NO_PERMISSION = "no permission";
    // 无此服务
    public final static String GATEWAY_CODE_NO_SERVICE = "404";
    public final static String GATEWAY_MSG_NO_SERVICE = "no service";
    // 未知错误
    public final static String GATEWAY_CODE_UNKNOW_ERROR = "500";
    public final static String GATEWAY_MSG_UNKNOW_ERROR = "unknow error";
    // 暂停服务
    public final static String GATEWAY_CODE_STOP_SERVICE = "503";
    public final static String GATEWAY_MSG_STOP_SERVICE = "stop service";


}

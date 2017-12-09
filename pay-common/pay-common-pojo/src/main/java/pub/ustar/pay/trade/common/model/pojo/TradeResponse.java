package pub.ustar.pay.trade.common.model.pojo;

/**
 * 网关公共响应参数
 * @author xy
 */
public class TradeResponse {
    // return_code|String|是|-|网关返回码|10000|
    private String returnCode;
    // return_msg|String|是|-|网关返回码描述||
    private String returnMsg;
    // result_code|String|否|-|业务返回码||
    private String resultCode;
    // result_msg|String|否|-|业务返回码描述||
    private String resultMsg;
    // sign|String|否|-|签名||
    private String sign;
    // biz_content|String|否|-|业务内容||
    private String bizContent;
}

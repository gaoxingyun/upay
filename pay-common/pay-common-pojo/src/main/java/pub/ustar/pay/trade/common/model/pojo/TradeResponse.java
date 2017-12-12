package pub.ustar.pay.trade.common.model.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;

/**
 * 网关公共响应参数
 *
 * @author xy
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TradeResponse {
    /**
     * code|String|是|-|网关返回码|10000|
     */
    protected String code;
    /**
     * msg|String|是|-|网关返回码描述||
     */
    protected String msg;
    /**
     * timestamp|String|是|19|发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"|2011-11-11 11:11:11|
     */
    private String timestamp;
    /**
     * sign|String|否|-|签名||
     */
    protected String sign;
    /**
     * biz_content|String|否|-|业务内容||
     */
    protected String bizContent;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }
}

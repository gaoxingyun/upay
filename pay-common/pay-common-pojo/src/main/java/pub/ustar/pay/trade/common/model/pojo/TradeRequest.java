package pub.ustar.pay.trade.common.model.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 网关公共请求参数
 *
 * @author xy
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TradeRequest {
    /**
     * app_id|String|是|32|分配给开发者的应用ID|1234567890|
     */
    private String appId;
    /**
     * method|String|是|32|接口名称|alipay.trade.pay|
     */
    private String method;
    /**
     * format|String|否|8|请求数据格式|JSON|
     */
    private String format;
    /**
     * charset|String|否|10|请求使用的编码格式|utf-8|
     */
    private String charset;
    /**
     * sign_type|String|否|10|商户生成签名字符串所使用的签名算法类型|md5|
     */
    private String signType;
    /**
     * sign|String|是|344|商户请求参数的签名串|1234567890|
     */
    private String sign;
    /**
     * timestamp|String|是|19|发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"|2011-11-11 11:11:11|
     */
    private String timestamp;
    /**
     * version|String|否|3|调用的接口版本号，不填默认最新版本|1.0|
     */
    private String version;
    /**
     * biz_content|String|是|-|业务内容||
     */
    private String bizContent;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }


}

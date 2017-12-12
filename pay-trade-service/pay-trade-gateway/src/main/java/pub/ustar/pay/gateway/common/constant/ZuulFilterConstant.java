package pub.ustar.pay.gateway.common.constant;

/**
 * 过滤器执行顺序常量
 *
 * @author xy
 */
public class ZuulFilterConstant {
    public final static Integer FILTER_ORDER_REQUEST_CONTEXT_ORDER = 10;
    public final static Integer FILTER_ORDER_RESPONSE_CONTEXT_ORDER = 10;

    public final static String FILTER_TYPE_PRE = "pre";
    public final static String FILTER_TYPE_POST = "post";

    public final static String FILTER_DEFAULT_ENCODING = "UTF-8";

    public final static String FILTER_REQUEST_FILTER_RESULT_KEY = "REQUEST_FILTER_RESULT";
    public final static String FILTER_REQUEST_FILTER_RESULT_VALUE_SUCCESS = "SUCCESS";
    public final static String FILTER_REQUEST_FILTER_RESULT_VALUE_FAILURE = "FAILURE";
}

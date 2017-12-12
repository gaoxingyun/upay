package pub.ustar.pay.gateway.common.util;

import java.time.LocalDateTime;

/**
 * 时间戳工具类
 *
 * @author xy
 */
public class TimestampUtils {

    /**
     * 检查时间戳是否合法
     *
     * @param timestamp  待检验时间戳 秒
     * @param errorValue 误差值
     * @return 时间戳是否合法
     */
    public static boolean checkTimestamp(long timestamp, int errorValue) {
        long serverTimestamp = getTimestamp();
        if (timestamp + errorValue > serverTimestamp && timestamp - errorValue < serverTimestamp) {
            return true;
        }
        return false;
    }

    /**
     * 获得时间戳 秒
     *
     * @return
     */
    public static Long getTimestamp() {
        return System.currentTimeMillis() / 1000;
    }
}

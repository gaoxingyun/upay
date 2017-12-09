package pub.ustar.pay.gateway.common.config;

import com.netflix.zuul.ZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pub.ustar.pay.gateway.common.filter.RequestJsonContentFilter;

/**
 * 用户自定义Zuul过滤器
 */
@Configuration
public class UserZuulFilterConfig {


    @Bean
    public ZuulFilter requestJsonContentFilter() {
        return new RequestJsonContentFilter();
    }
}

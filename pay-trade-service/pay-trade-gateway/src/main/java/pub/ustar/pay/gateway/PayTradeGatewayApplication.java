package pub.ustar.pay.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * springboot入口
 *
 * @author xy
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class PayTradeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayTradeGatewayApplication.class, args);
    }
}

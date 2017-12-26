package pub.ustar.pay.channel.alipay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PayChannelAlipayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayChannelAlipayApplication.class, args);
	}
}

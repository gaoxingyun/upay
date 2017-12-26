package pub.ustar.pay.channel.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PayChannelGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayChannelGatewayApplication.class, args);
	}
}

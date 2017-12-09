package pub.ustar.pay.trade.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class PayServiceQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayServiceQueryApplication.class, args);
	}
}

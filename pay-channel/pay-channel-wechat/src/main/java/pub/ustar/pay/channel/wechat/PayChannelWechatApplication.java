package pub.ustar.pay.channel.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PayChannelWechatApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayChannelWechatApplication.class, args);
	}
}

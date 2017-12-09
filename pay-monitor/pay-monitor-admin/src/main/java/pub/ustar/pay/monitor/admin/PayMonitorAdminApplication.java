package pub.ustar.pay.monitor.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class PayMonitorAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayMonitorAdminApplication.class, args);
	}
}

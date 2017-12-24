package pub.ustar.pay.monitor.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

@EnableZipkinStreamServer
@EnableDiscoveryClient
@SpringBootApplication
public class PayMonitorLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayMonitorLogApplication.class, args);
    }
}

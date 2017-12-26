package pub.ustar.pay.trade.query.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/config")
public class TestConfigController {

    @Value("${config.test}")
    public String test;

    @RequestMapping("/test")
    public String test() {
        return test;
    }
}

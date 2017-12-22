package tianjian;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/20.
 */
@SpringBootApplication
@RestController
public class ConfigClient {

    @Value("${bar}")
    private String bar;

    @RequestMapping("/")
    public String home() {
        return bar;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }

}
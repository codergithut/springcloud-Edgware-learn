package tianjian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tianjian.config.Config;
import tianjian.domain.FooProperties;
import tianjian.domain.MailProperties;
import tianjian.domain.MailPropertiesCopy;
import tianjian.domain.SimpleDataBase;

import java.util.List;

/**
 * Created by Administrator on 2017/12/20.
 */
@RestController
public class MyRestController {
    @Autowired
    SimpleDataBase simpleDataBase;

    @Autowired
    MailPropertiesCopy mailPropertiesCopy;

    @Autowired
    MailProperties mailProperties;

    @Autowired
    Config config;

    @Autowired
    FooProperties fooProperties;

    @GetMapping("test")
    public String testRestController() {
        List<String> data = config.getServers();
        String key = fooProperties.getList().get(0).getDescription();
        return "simple:" + simpleDataBase.getUrl()
                + ", mailPropertiesCopy port is :"
                + mailPropertiesCopy.getPort()
                + ", mailProperties port is :"
                + mailProperties.getPort();
    }
}

package tianjian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tianjian.config.common.Config;
import tianjian.domain.common.FooProperties;
import tianjian.domain.common.MailProperties;
import tianjian.domain.common.MailPropertiesCopy;
import tianjian.domain.common.SimpleDataBase;
import tianjian.exception.web.rest.RestHandlerException;

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

    @GetMapping("exception")
    public String testException() throws RestHandlerException {
        throw new RestHandlerException("人为异常");
    }

    @GetMapping("xx")
    public String testHelloWorld() {
        return "Hello World";
    }
}

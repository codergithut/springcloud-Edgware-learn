package tianjian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tianjian.config.ElasticsearchConfig;
import tianjian.domain.MailProperties;
import tianjian.domain.MailPropertiesCopy;
import tianjian.domain.SimpleDataBase;

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
    ElasticsearchConfig elasticsearchConfig;

    @GetMapping("test")
    public String testRestController() {
        elasticsearchConfig.tges();
        return "simple:" + simpleDataBase.getUrl()
                + ", mailPropertiesCopy port is :"
                + mailPropertiesCopy.getPort()
                + ", mailProperties port is :"
                + mailProperties.getPort();
    }
}

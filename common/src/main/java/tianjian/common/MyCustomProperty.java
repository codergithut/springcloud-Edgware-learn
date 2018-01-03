package tianjian.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tianjian.domain.common.FooProperties;
import tianjian.domain.common.MailPropertiesCopy;
import tianjian.domain.common.SimpleDataBase;

/**
 * Created by Administrator on 2017/12/20.
 */
@Configuration
public class MyCustomProperty {

    @Value("${custom.config}")
    private String msg;

    @Bean
    public SimpleDataBase getSimpleDataBase() {
        SimpleDataBase simpleDataBase = new SimpleDataBase();
        simpleDataBase.setUrl(msg);
        return simpleDataBase;
    }

    @Bean
    @ConfigurationProperties(prefix = "foo")
    public FooProperties getFoo() {
        return new FooProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "mail")
    public MailPropertiesCopy connectionSettings(){
        return new MailPropertiesCopy();
    }

}

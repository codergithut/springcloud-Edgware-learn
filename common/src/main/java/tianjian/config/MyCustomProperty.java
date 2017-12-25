package tianjian.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tianjian.domain.FooProperties;
import tianjian.domain.MailPropertiesCopy;
import tianjian.domain.SimpleDataBase;

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

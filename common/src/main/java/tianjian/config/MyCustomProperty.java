package tianjian.config;

import io.searchbox.client.config.HttpClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.elasticsearch.jest.HttpClientConfigBuilderCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    @ConfigurationProperties(prefix = "mail")
    public MailPropertiesCopy connectionSettings(){
        return new MailPropertiesCopy();
    }

    static class HttpSettingsCustomizer implements HttpClientConfigBuilderCustomizer {

        @Override
        public void customize(HttpClientConfig.Builder builder) {
            builder.maxTotalConnection(100).defaultMaxTotalConnectionPerRoute(5);
        }

    }

}

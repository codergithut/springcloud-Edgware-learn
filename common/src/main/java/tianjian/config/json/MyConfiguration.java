package tianjian.config.json;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import tianjian.util.message.HttpMessageConverterImpl;

/**
 * json转换器没有写对呢(笑) 放开注解会帮你系统快速失败
 */
//@Configuration
public class MyConfiguration {
    @Bean
    public HttpMessageConverters customConverters() {
        HttpMessageConverter<?> additional = new HttpMessageConverterImpl();
        HttpMessageConverter<?> another = new HttpMessageConverterImpl();
        return new HttpMessageConverters(additional, another);
    }

}

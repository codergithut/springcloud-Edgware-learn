package tianjian.elas;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/12/5
 * @description
 */
@Configuration
public class ElasticsearchClientConfig {

    @Value("${spring.elasticsearch.host}")
    private String host;
    @Value("${spring.elasticsearch.port}")
    private int port;

    /**
     * @return restClient
     * @description 連接ES服務的client
     */
    @Bean
    public RestClient elasticsearchClient(){   //向spring注入es的客户端操作对象
        RestClient restClient = RestClient.builder(
                new HttpHost(host, port, "http")).build();
        return restClient;

    }

}

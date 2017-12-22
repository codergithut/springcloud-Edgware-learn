package tianjian.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchConfig {

    private ElasticsearchTemplate template;

    @Autowired
    public ElasticsearchConfig(ElasticsearchTemplate template) {
        this.template = template;
    }

    public void tges() {
        template.createIndex("test");
    }

}

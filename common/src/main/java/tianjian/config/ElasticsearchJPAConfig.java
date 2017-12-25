package tianjian.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchJPAConfig {

    private ElasticsearchTemplate template;

    @Autowired
    public ElasticsearchJPAConfig(ElasticsearchTemplate template) {
        this.template = template;
    }

    public void tges() {
        template.createIndex("test");
    }

}

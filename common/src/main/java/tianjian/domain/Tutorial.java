package tianjian.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName="tutorial",type="tutorial",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Tutorial implements Serializable {
    private Long id;
    private String name;//教程名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

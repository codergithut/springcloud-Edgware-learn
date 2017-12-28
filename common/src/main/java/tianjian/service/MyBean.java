package tianjian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tianjian.domain.bean.Details;

@Service
public class MyBean {

    private final RestTemplate restTemplate;

    @Autowired
    public MyBean(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Details someRestCall(String name) {
        return this.restTemplate.getForObject("http://127.0.0.1:8300/{name}/details", Details.class, name);
    }

}

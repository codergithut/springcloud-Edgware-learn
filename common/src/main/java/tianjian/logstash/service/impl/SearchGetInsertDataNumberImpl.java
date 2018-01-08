package tianjian.logstash.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;
import tianjian.domain.logstash.LogStashInfo;
import tianjian.logstash.service.GetInsertDataNumber;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Service
public class SearchGetInsertDataNumberImpl implements GetInsertDataNumber{
    @Override
    public long getInsertDataNumber(LogStashInfo info) throws IOException {
        RestClient restClient = RestClient.builder(
                new HttpHost(info.getEl_host(), Integer.valueOf(info.getEl_port()), "http")).build();
        Map<String, String> params = Collections.emptyMap();
        String s = EntityUtils.toString(restClient.performRequest("GET", "/mysql01/_search", params).getEntity());
        JSONObject json = JSONObject.parseObject(s);
        JSONObject json1 = (JSONObject)json.get("hits");
        long total = Long.valueOf(json1.getString("total"));
        return total;
    }
}

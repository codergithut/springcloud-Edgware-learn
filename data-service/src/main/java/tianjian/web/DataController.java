package tianjian.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.log4j.Logger;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tianjian.jdbc.JsonResultSetExtractor;
import tianjian.util.EsUtil;

import java.io.IOException;

@RestController
public class DataController {

    Logger logger = Logger.getLogger(DataController.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("getData")
    public Object getData() throws IOException, InterruptedException {
        logger.info("测试日志");
        RestClient restClient = RestClient.builder(
                new HttpHost("12.0.0.1", 9200, "http")).build();
        JSONArray jsons = jdbcTemplate.query("select * from test", new JsonResultSetExtractor());
        for(JSONObject json : JSONArray.parseArray(jsons.toJSONString(), JSONObject.class)){
            EsUtil.addBeanToEs("db", json, restClient);

        }


        return jsons;
    }

}

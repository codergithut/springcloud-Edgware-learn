package tianjian.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.*;

public class EsUtil {

    /**
     *
     * @param index 索引
     * @param o 需要添加是数据
     * @param restClient 客户端
     * @return
     * @throws IOException
     * @description 将数据插入到ES服务器中
     */
    public static String addBeanToEs(String index, JSONObject o, RestClient restClient) throws IOException, InterruptedException {
        String id = UUID.randomUUID().toString();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("doc", o);
        NStringEntity entity =  new NStringEntity(jsonObject.toString(), "UTF-8");
        System.out.println(jsonObject.toString());
        Response response = commonDoEs("PUT", index + "/"  + id,entity , restClient);
        return id;
    }

    /**
     *
     * @param method 请求方式
     * @param endpoint 请求路径
     * @param httpEntity 请求数据
     * @param restClient 客户端
     * @return
     * @throws IOException
     * @description 操作ES数据的一般套路
     */
    private static Response commonDoEs(String method, String endpoint, HttpEntity httpEntity, RestClient restClient) throws IOException {
        Map<String, String> params = Collections.emptyMap();
        if(httpEntity != null ) {
            return restClient.performRequest(method, endpoint, params, httpEntity);
        } else {
            return restClient.performRequest(method, endpoint, params);
        }
    }


}

package tianjian.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import tianjian.domain.elas.EsEntity;
import tianjian.domain.elas.search.DSLParam;
import tianjian.domain.elas.search.Fuzziness;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static tianjian.common.Constant.SEARCH_DSL;


public class EsUtil {

    /**
     *
     * @param index 索引
     * @param data 数据体
     * @param restClient 客户端
     * @return
     * @throws IOException
     * @description 将数据插入到ES服务器中
     */
    public static String addBeanToEs(String index, EsEntity data, RestClient restClient) throws IOException, InterruptedException {
        String id = UUID.randomUUID().toString();
        data.setId(id);
        Response response = commonDoEs("PUT", index + "/"  + id, getHttpEntityByEsEntity(data, "add"), restClient);
        return id;
    }

    /**
     *
     * @param index 索引
     * @param docID 文章ID
     * @param restClient 客户端
     * @return
     * @throws IOException
     * @description 根据文章ID删除ES数据
     */
    public static boolean deleteBeanToEs(String index, String docID, RestClient restClient) throws IOException, InterruptedException {
        try{
            Response response = commonDoEs("DELETE", index + "/"  + docID + "?refresh", null, restClient);
        }catch (IOException e) {
        }
        return true;
    }

    /**
     *
     * @param index 索引
     * @param data 需要跟新的文件对象
     * @param restClient 客户端
     * @return
     * @throws IOException
     * @description 根据文章ID跟新ES数据
     */
    public static boolean updateBeanToEs(String index,EsEntity data, RestClient restClient) throws InterruptedException {
        try{
            Response response = commonDoEs("POST", index + "/"  + data.getId() + "/_update?refresh", getHttpEntityByEsEntity(data, "update"), restClient);
        }catch (IOException e) {
        }
        return true;
    }

    /**
     *
     * @param index 索引
     * @param restClient 客户端
     * @param dslParam DSL查询条件封装
     * @param t 需要转换的class
     * @param <T> 泛型对象
     * @return
     * @throws IOException
     * @description 查询文章信息
     */
    public static <T extends EsEntity> PageImpl<T> searchBeanFrommEs(String index, DSLParam dslParam, RestClient restClient, PageRequest page, Class<T> t,HttpEntity httpEntity) throws IOException, InterruptedException {
        String searchDSL = SEARCH_DSL.replace("${index}",index)
                .replace("${size}", page.getPageSize() + "")
                .replace("${from}", (page.getPageNumber()-1) * page.getPageSize() + "");

        if(dslParam.getSortParam().size() == 0) {
            searchDSL = searchDSL.replace("${sortName}:${type}", "");
        } else {
            searchDSL = searchDSL.replace("${sortName}", dslParam.getSortParam().get(0).getFileName())
                    .replace("${type}", dslParam.getSortParam().get(0).getSortEnum().getName());
        }

        if(dslParam.getSearchParam().size() == 0) {
            searchDSL = searchDSL.replace("${fileName}:${fileValue}", "");
        } else {
            searchDSL = searchDSL.replace("${fileName}", dslParam.getSearchParam().get(0).getFileName())
                    .replace("${fileValue}", dslParam.getSearchParam().get(0).getFileValue());
        }

        Response response = commonDoEs("GET", searchDSL,
                httpEntity, restClient);
        String s = EntityUtils.toString(response.getEntity());
        System.out.println();
        return changeStringToBean(s, t, page);
    }

    public static <T extends EsEntity> PageImpl<T> searchBeanFrommEs(String index, DSLParam dslParam, RestClient restClient, PageRequest page, Class<T> t) throws IOException, InterruptedException {
        return searchBeanFrommEs(index, dslParam, restClient, page, t,null);
    }


    /**
     *
     * @param index 索引
     * @param restClient 客户端
     * @param dslParam DSL查询条件封装
     * @param t 需要转换的class
     * @param <T> 泛型对象
     * @return
     * @throws IOException
     * @description 查询文章信息
     */
    public static <T extends EsEntity> PageImpl<T> searchBeanFzinessFrommEs(String index, DSLParam dslParam, RestClient restClient, PageRequest page, Class<T> t, Fuzziness fuzziness) throws IOException, InterruptedException {
        Map<String, Object> entity = new HashMap<String,Object>();
        Map<String, Object> value = new HashMap<String,Object>();
        value.put("multi_match", fuzziness);
        entity.put("query", value);
        System.out.println(JSON.toJSONString(entity));
        HttpEntity httpEntity = new NStringEntity(JSON.toJSONString(entity), "UTF-8");
        return searchBeanFrommEs(index, dslParam, restClient, page, t,httpEntity);
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

    /**
     *
     * @param esEntity 请求对象
     * @param type 文件类型
     * @return
     * @throws UnsupportedEncodingException
     * @description 封装的请求对象
     */
    public static HttpEntity getHttpEntityByEsEntity(EsEntity esEntity, String type) throws UnsupportedEncodingException {
        if(esEntity == null) {
            return null;
        }
        if(!type.equals("update")) {
            return new NStringEntity(esEntity.toString(), "UTF-8");
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("doc", esEntity);
            return new NStringEntity(jsonObject.toString(), "UTF-8");
        }

    }


    /**
     *
     * @param data 需要转换的json数据
     * @param t 需要转换的对象的class对象
     * @param <T> 泛型
     * @return 转换后的对象
     */
    public static <T extends EsEntity> PageImpl<T> changeStringToBean(String data, Class<T> t, PageRequest pageRequest){

        List<T> datas = new ArrayList<T>();

        JSONObject jsonObject = JSON.parseObject(data.replaceAll("/n", ""));
        JSONObject jsonObject1 = (JSONObject)jsonObject.get("hits");

        Long total = Long.valueOf(jsonObject1.get("total").toString());

        JSONArray jsonObject2 = (JSONArray)jsonObject1.get("hits");

        for(JSONObject jsonObject3 : jsonObject2.toJavaList(JSONObject.class)) {
            System.out.println(jsonObject3.getString("_source"));
            T t1 = JSONObject.parseObject(jsonObject3.getString("_source"), t);
            datas.add(t1);
        }

        PageImpl<T> pageimpl = new PageImpl<T>(datas, pageRequest, total);

        return pageimpl;
    }
}

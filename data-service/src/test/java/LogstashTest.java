
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

public class LogstashTest {

    @Test
    public void testLogstash() {

        RestTemplate restTemplate=new RestTemplate();
        String url="http://127.0.0.1:8000";
        /* 注意：必须 http、https……开头，不然报错，浏览器地址栏不加 http 之类不出错是因为浏览器自动帮你补全了 */
        HttpHeaders headers = new HttpHeaders();

        LinkedMultiValueMap body=new LinkedMultiValueMap();
        body.add("var1","测试数据1");
        body.add("var2","test Val2");

        /* 这个对象有add()方法，可往请求头存入信息 */
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        /* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        HttpEntity<String> entity = new HttpEntity<String>(body.toString(), headers);
        /* body是Http消息体例如json串 */
        restTemplate.exchange(url, HttpMethod.GET, entity, String.class);


    }

}

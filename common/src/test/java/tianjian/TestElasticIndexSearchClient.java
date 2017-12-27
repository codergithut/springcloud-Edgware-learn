package tianjian;

import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import tianjian.domain.client.Index;
import tianjian.service.impl.IndexServcieImpl;
import tianjian.util.EsUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class TestElasticIndexSearchClient {

    RestClient restClient;
    IndexServcieImpl indexServcie;

    @Before
    public void initRestClient(){
        restClient = RestClient.builder(
                new HttpHost("127.0.0.1", 9200, "http")).build();
        indexServcie = new IndexServcieImpl();
        indexServcie.setRestClient(restClient);
    }



    @Test
    public void testElasticSearchClient() throws IOException, InterruptedException {

        /**
         * 测试目录为
         * 这是父目录甲
         *   这是子目录甲
         *    这是子目录甲的子目录
         *   这是子目录乙
         *  然后修改了父目录的描述为 '我修改了自己的描述 '
         */
        String parentId = null;

//        for(int i = 0; i < 100; i++) {
//            Index index = new Index();
//            index.setCategoryid(UUID.randomUUID().toString());
//            index.setDescription("这是父目录甲");
//            index.setIsroot("true");
//            index.setParentid("null");
//            index.setSort(i);
//            System.out.println(index.toString());
//            indexServcie.addIndex(index);
//        }

        Index index = new Index();
        index.setCategoryid(UUID.randomUUID().toString());
        index.setDescription("这是父目录甲");
        index.setIsroot("true");
        index.setParentid("null");
        index.setSort(101);
        System.out.println(index.toString());
        parentId = indexServcie.addIndex(index);



        Index detail01 = new Index();
        detail01.setCategoryid(UUID.randomUUID().toString());
        detail01.setDescription("这是子目录甲");
        detail01.setIsroot("false");
        detail01.setParentid(parentId);

        String parentId01 = indexServcie.addIndex(detail01);
        Index detail11 = new Index();
        detail11.setCategoryid(UUID.randomUUID().toString());
        detail11.setDescription("这是子目录甲的子目录");
        detail11.setId(UUID.randomUUID().toString());
        detail11.setIsroot("false");
        detail11.setParentid(parentId01);

        indexServcie.addIndex(detail11);
        Index detail02 = new Index();
        detail02.setCategoryid(UUID.randomUUID().toString());
        detail02.setDescription("这是子目录乙");
        detail02.setIsroot("false");
        detail02.setParentid(parentId);

        indexServcie.addIndex(detail02);

        List<Index> indexList01 = indexServcie.getParentIndex();

        List<Index> indexList02 = indexServcie.getIndexByParentId(parentId);

        List<Index> indexList03 = indexServcie.getIndexByParentId(parentId01);

        Index parentIndex = indexServcie.searchIndexById(parentId);

        //assertEquals("这是父目录甲", parentIndex.getDescription());

        index.setDescription("我修改了自己的描述");

        indexServcie.updateIndex(index);

//        Thread.sleep(1000l);

        System.out.println("before");
        Index updaateIndex = indexServcie.searchIndexById(parentId);
        assertEquals("我修改了自己的描述", updaateIndex.getDescription());

    }


    @Test
    @Ignore
    public void tesstAsyncElasticClient() throws IOException, InterruptedException {

        Index index = new Index();
        index.setCategoryid(UUID.randomUUID().toString());
        index.setDescription("这是父目录甲");
        index.setIsroot("true");
        index.setParentid("null");
        String parentId = indexServcie.addIndex(index);

        Index parentIndex = indexServcie.searchIndexById(parentId);

        index.setDescription("我修改了自己的描述");

        Map<String, String> params = Collections.emptyMap();

        MyResponseListener myResponseListener = new MyResponseListener();

        restClient.performRequestAsync("POST", "myindex/mulu?refresh=true", params, EsUtil.getHttpEntityByEsEntity(index, "update"),myResponseListener);

        Thread.sleep(10000l);

        System.out.println("before");
        Index updaateIndex = indexServcie.searchIndexById(parentId);

        assertEquals("我修改了自己的描述", updaateIndex.getDescription());

    }

    private class MyResponseListener implements ResponseListener {

        @Override
        public void onSuccess(Response response) {
            try {
                System.out.println("================+++++++++++++++++++update" + EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onFailure(Exception exception) {

        }
    }


}

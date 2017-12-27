package tianjian.service.impl;

import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tianjian.domain.client.Index;
import tianjian.domain.client.search.DSLParam;
import tianjian.domain.client.search.SortEnum;
import tianjian.service.IndexService;
import tianjian.util.EsUtil;

import java.io.IOException;
import java.util.List;

import static tianjian.config.Constant.INDEX_MY;

@Service
public class IndexServcieImpl implements IndexService {
    /**
     * restClient 用于连接ES服务
     */
    @Autowired
    RestClient restClient;

    @Override
    public String addIndex(Index index) throws IOException, InterruptedException {
         return EsUtil.addBeanToEs(INDEX_MY, index, restClient);
    }

    @Override
    public boolean deleteIndex(String indexId) throws IOException, InterruptedException {
        Index Index = searchIndexById(indexId);
        return EsUtil.deleteBeanToEs(INDEX_MY, indexId,restClient);
    }

    @Override
    public boolean updateIndex(Index index) throws InterruptedException {
        return EsUtil.updateBeanToEs(INDEX_MY, index, restClient);
    }

    @Override
    public Index searchIndexById(String id) throws IOException, InterruptedException {
        PageRequest pageRequest = new PageRequest(1,1);
        DSLParam dslParam = new DSLParam();
        dslParam.setSortParam("sort",  SortEnum.ASC).setSearchParam("id", id);
        List<Index> indexs = EsUtil.searchBeanFrommEs(INDEX_MY, dslParam, restClient, pageRequest, Index.class).getContent();
        if(indexs.size() > 0) {
            return indexs.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Index> getParentIndex() throws IOException, InterruptedException {
        PageRequest pageRequest = new PageRequest(1,1000);

        DSLParam dslParam = new DSLParam();
        dslParam.setSortParam("sort",  SortEnum.ASC).setSearchParam("isroot", "true");

        List<Index> indexs = EsUtil.searchBeanFrommEs(INDEX_MY,dslParam, restClient, pageRequest, Index.class).getContent();
        if(indexs.size() > 0) {
            return indexs;
        } else {
            return null;
        }
    }

    @Override
    public List<Index> getIndexByParentId(String parentId) throws IOException, InterruptedException {
        PageRequest pageRequest = new PageRequest(1,1000);
        DSLParam dslParam = new DSLParam();
        dslParam.setSortParam("sort",  SortEnum.ASC).setSearchParam("parentid", parentId);
        List<Index> indexs = EsUtil.searchBeanFrommEs(INDEX_MY,dslParam, restClient, pageRequest, Index.class).getContent();
        if(indexs.size() > 0) {
            return indexs;
        } else {
            return null;
        }
    }

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }
}

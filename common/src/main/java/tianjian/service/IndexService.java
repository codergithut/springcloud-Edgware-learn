package tianjian.service;


import tianjian.domain.elas.Index;

import java.io.IOException;
import java.util.List;

public interface IndexService {
    /**
     *
     * @param index 需要添加的目录
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    String addIndex(Index index) throws IOException, InterruptedException;

    /**
     *
     * @param indexId 删除目录的id
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    boolean deleteIndex(String indexId) throws IOException, InterruptedException;

    /**
     *
     * @param index 更新的目录
     * @return
     * @throws InterruptedException
     */
    boolean updateIndex(Index index) throws InterruptedException;

    /**
     *
     * @param id 需要查询目录的id
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    Index searchIndexById(String id) throws IOException, InterruptedException;

    /**
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     * 获取第一层级目录
     */
    List<Index> getParentIndex() throws IOException, InterruptedException;

    /**
     *
     * @param parentId 按照父目录获取子目录
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    List<Index> getIndexByParentId(String parentId) throws IOException, InterruptedException;

}

package tianjian.service.impl;

import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tianjian.domain.elas.Article;
import tianjian.domain.elas.Comment;
import tianjian.domain.elas.search.DSLParam;
import tianjian.domain.elas.search.Fuzziness;
import tianjian.domain.elas.search.SortEnum;
import tianjian.service.ArticleBaseService;
import tianjian.util.EsUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static tianjian.common.Constant.INDEX_ARTICLE;
import static tianjian.common.Constant.INDEX_COMMENT;


/**
 * 见接口说明
 */
@Service
public class ArticleBaseServiceImpl implements ArticleBaseService {

    /**
     * restClient 用于连接ES服务
     */
    @Autowired
    RestClient restClient;

    @Override
    public Article getArticleById(String id) throws IOException, InterruptedException {
        PageRequest pageRequest = new PageRequest(1,1);

        DSLParam dslParam = new DSLParam();
        dslParam.setSortParam("updatetime",  SortEnum.DESC).setSearchParam("answersid", id);

        List<Article> articles = EsUtil.searchBeanFrommEs(INDEX_ARTICLE, dslParam,
                restClient, pageRequest, Article.class).getContent();
        if (articles.size() > 0) {
            return articles.get(0);
        } else {
            return null;
        }
    }

    @Override
    public PageImpl<Article> getArticleBydCategoryid(String categoryid, PageRequest pageRequest) throws IOException, InterruptedException {
        DSLParam dslParam = new DSLParam();
        dslParam.setSortParam("updatetime",  SortEnum.DESC).setSearchParam("categoryid", categoryid);
        return EsUtil.searchBeanFrommEs(INDEX_ARTICLE,dslParam, restClient, pageRequest, Article.class);
    }

    @Override
    public Comment getCommentById(String id) throws IOException, InterruptedException {
        PageRequest pageRequest = new PageRequest(1,1);
        DSLParam dslParam = new DSLParam();
        dslParam.setSortParam("updatetime",  SortEnum.DESC).setSearchParam("commentid", id);
        List<Comment> comments = EsUtil.searchBeanFrommEs(INDEX_COMMENT,dslParam, restClient, pageRequest, Comment.class).getContent();
        if(comments.size() > 0) {
            return comments.get(0);
        } else {
            return null;
        }
    }

    @Override
    public PageImpl<Comment> getCommentByAritcleId(String articleId, PageRequest pageRequest) throws IOException, InterruptedException {
        DSLParam dslParam = new DSLParam();
        dslParam.setSortParam("updatetime",  SortEnum.DESC).setSearchParam("replyid", articleId);
        return EsUtil.searchBeanFrommEs(INDEX_COMMENT,dslParam, restClient,pageRequest, Comment.class);
    }

    @Override
    public PageImpl<Article> getArticleByFuzzines(String query, PageRequest pageRequest) throws IOException, InterruptedException {
        DSLParam dslParam = new DSLParam();
        Fuzziness fuzziness = new Fuzziness();
        List<String> data = new ArrayList<String>();
        data.add("describe");
        data.add("author");
        data.add("htmlcontent");
        data.add("title");
        fuzziness.setFields(data);
        fuzziness.setFuzziness("AUTO");
        return EsUtil.searchBeanFzinessFrommEs(INDEX_ARTICLE,dslParam, restClient, pageRequest, Article.class, fuzziness);
    }

    @Override
    public PageImpl<Comment> getCommentByCommentId(String commmentId, PageRequest pageRequest) throws IOException, InterruptedException {
        DSLParam dslParam = new DSLParam();
        dslParam.setSortParam("updatetime",  SortEnum.DESC).setSearchParam("replyid", commmentId);
        return EsUtil.searchBeanFrommEs(INDEX_COMMENT, dslParam, restClient, pageRequest, Comment.class);
    }

    @Override
    public boolean deleteArticleById(String articleId) throws IOException, InterruptedException {
        return EsUtil.deleteBeanToEs(INDEX_ARTICLE, articleId,restClient);
    }

    @Override
    public boolean deleteCommentById(String commentId) throws IOException, InterruptedException {
        return EsUtil.deleteBeanToEs(INDEX_COMMENT, commentId,restClient);
    }

    @Override
    public String addArticle(Article article) throws IOException, InterruptedException {
        return EsUtil.addBeanToEs(INDEX_ARTICLE, article, restClient);
    }

    @Override
    public String addComment(Comment comment) throws IOException, InterruptedException {
        return EsUtil.addBeanToEs(INDEX_COMMENT, comment, restClient);
    }

    @Override
    public boolean updateCommentEsData(Comment comment) throws InterruptedException {
        return EsUtil.updateBeanToEs(INDEX_COMMENT, comment, restClient);
    }

    @Override
    public boolean updateArticleEsData(Article article) throws InterruptedException {
        return EsUtil.updateBeanToEs(INDEX_ARTICLE, article, restClient);
    }

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }
}

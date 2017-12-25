package tianjian.service.impl;


import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tianjian.domain.dev.Article;
import tianjian.domain.dev.Comment;
import tianjian.service.ArticleBaseService;
import tianjian.util.EsUtil;

import java.io.IOException;
import java.util.List;

import static tianjian.config.Constant.INDEX_ARTICLE;
import static tianjian.config.Constant.INDEX_COMMENT;

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
    public Article getArticleById(String id) throws IOException {
        return EsUtil.searchBeanFrommEs(INDEX_ARTICLE,id, "answersid", restClient, Article.class).get(0);
    }

    @Override
    public Comment getCommentById(String id) throws IOException {
        return EsUtil.searchBeanFrommEs(INDEX_COMMENT,id, "commentid", restClient, Comment.class).get(0);
    }

    @Override
    public List<Comment> getCommentByAritcleId(String articleId) throws IOException {
        return EsUtil.searchBeanFrommEs(INDEX_COMMENT,articleId, "replyid", restClient, Comment.class);
    }

    @Override
    public List<Comment> getCommentByCommentId(String commmentId) throws IOException {
        return EsUtil.searchBeanFrommEs(INDEX_COMMENT,commmentId, "replyid", restClient, Comment.class);
    }

    @Override
    public boolean deleteArticleById(String articleId) throws IOException {
        return EsUtil.deleteBeanToEs(INDEX_ARTICLE, articleId,restClient);
    }

    @Override
    public boolean deleteCommentById(String commentId) throws IOException {
        return EsUtil.deleteBeanToEs(INDEX_COMMENT, commentId,restClient);
    }

    @Override
    public boolean addArticle(Article article) throws IOException {
        return EsUtil.addBeanToEs(INDEX_ARTICLE, article.getAnswersid(), article, restClient);
    }

    @Override
    public boolean addComment(Comment comment) throws IOException {
        return EsUtil.addBeanToEs(INDEX_COMMENT, comment.getCommentid(), comment, restClient);
    }

    @Override
    public boolean updateCommentEsData(Comment comment) {
        return EsUtil.updateBeanToEs(INDEX_COMMENT, comment, restClient);
    }

    @Override
    public boolean updateArticleEsData(Article article) {
        return EsUtil.updateBeanToEs(INDEX_ARTICLE, article, restClient);
    }
}

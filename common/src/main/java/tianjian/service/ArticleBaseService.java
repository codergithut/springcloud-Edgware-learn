package tianjian.service;

import tianjian.domain.client.Article;
import tianjian.domain.client.Comment;

import java.io.IOException;
import java.util.List;

public interface ArticleBaseService {
    /**
     *
     * @param id 需要获取文章的ID
     * @return 文章信息
     * @throws IOException
     */
    Article getArticleById(String id) throws IOException;

    /**
     *
     * @param id 评论ID
     * @return 评论
     * @throws IOException
     */
    Comment getCommentById(String id) throws IOException;

    /**
     *
     * @param articleId 文章ID
     * @return 获取评论该文章的评论(直接)
     * @throws IOException
     */
    List<Comment> getCommentByAritcleId(String articleId) throws IOException;

    /**
     *
     * @param commmentId 评论ID
     * @return 获取评论该评论的ID
     * @throws IOException
     */
    List<Comment> getCommentByCommentId(String commmentId) throws IOException;

    /**
     *
     * @param articleId 需要删除文章的ID
     * @return true 成功,false 失败
     * @throws IOException
     */
    boolean deleteArticleById(String articleId) throws IOException;

    /**
     *
     * @param commentId 需要删除评论的ID
     * @return true 成功,false 失败
     * @throws IOException
     */
    boolean deleteCommentById(String commentId) throws IOException;

    /**
     *
     * @param article 需要添加的文章信息
     * @return true 成功, false 失败
     * @throws IOException
     */
    boolean addArticle(Article article) throws IOException;

    /**
     *
     * @param comment 需要添加的评论信息
     * @return true 成功, false失败
     * @throws IOException
     */
    boolean addComment(Comment comment) throws IOException;

    /**
     *
     * @param comment 需要更新的评论ID
     * @return true 成功, false 失败
     */
    boolean updateCommentEsData(Comment comment);

    /**
     *
     * @param article 需要更新的ID
     * @return true 成功, false 失败
     */
    boolean updateArticleEsData(Article article);


}

package tianjian.service;


import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import tianjian.domain.elas.Article;
import tianjian.domain.elas.Comment;

import java.io.IOException;

public interface ArticleBaseService {
    /**
     *
     * @param id 需要获取文章的ID
     * @return 文章信息
     * @throws IOException
     */
    Article getArticleById(String id) throws IOException, InterruptedException;

    /**
     *
     * @param categoryid 分类ID
     * @return 文章信息
     */
    PageImpl<Article> getArticleBydCategoryid(String categoryid, PageRequest pageRequest) throws IOException, InterruptedException;

    /**
     *
     * @param id 评论ID
     * @return 评论
     * @throws IOException
     */
    Comment getCommentById(String id) throws IOException, InterruptedException;

    /**
     *
     * @param articleId 文章ID
     * @return 获取评论该文章的评论(直接)
     * @throws IOException
     */
    PageImpl<Comment> getCommentByAritcleId(String articleId, PageRequest pageRequest) throws IOException, InterruptedException;

    /**
     *
     * @param commmentId 评论ID
     * @return 获取评论该评论的ID
     * @throws IOException
     */
    PageImpl<Comment> getCommentByCommentId(String commmentId, PageRequest pageRequest) throws IOException, InterruptedException;

    /**
     *
     * @param articleId 需要删除文章的ID
     * @return true 成功,false 失败
     * @throws IOException
     */
    boolean deleteArticleById(String articleId) throws IOException, InterruptedException;

    /**
     *
     * @param commentId 需要删除评论的ID
     * @return true 成功,false 失败
     * @throws IOException
     */
    boolean deleteCommentById(String commentId) throws IOException, InterruptedException;

    /**
     *
     * @param article 需要添加的文章信息
     * @return true 成功, false 失败
     * @throws IOException
     */
    String addArticle(Article article) throws IOException, InterruptedException;

    /**
     *
     * @param comment 需要添加的评论信息
     * @return true 成功, false失败
     * @throws IOException
     */
    String addComment(Comment comment) throws IOException, InterruptedException;

    /**
     *
     * @param comment 需要更新的评论ID
     * @return true 成功, false 失败
     */
    boolean updateCommentEsData(Comment comment) throws InterruptedException;

    /**
     *
     * @param article 需要更新的ID
     * @return true 成功, false 失败
     */
    boolean updateArticleEsData(Article article) throws InterruptedException;


}

package tianjian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tianjian.domain.elas.Article;
import tianjian.domain.elas.Comment;
import tianjian.domain.elas.Index;
import tianjian.service.ArticleBaseService;
import tianjian.service.IndexService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("dev/data")
public class EsDataController {

    @Autowired
    ArticleBaseService articleBaseService;

    @Autowired
    IndexService indexService;

    /**
     * @param article 文章对象
     * @throws IOException
     * 添加文章信息
     */
    @PostMapping("/add/article")
    public String addArticle(Article article) throws IOException, InterruptedException {
        article.setCreatetime(new Date());
        return articleBaseService.addArticle(article);
    }

    /**
     * @param id 文章id
     * @throws IOException
     * 查找文章信息
     */
    @PostMapping("search/article")
    public Article searchArticle(String id) throws IOException, InterruptedException {
        return articleBaseService.getArticleById(id);
    }

    /**
     * @param id 文章id
     * @throws IOException
     * 查找文章信息
     */
    @PostMapping("search/category")
    public PageImpl<Article> searchArticleByCategoryId(String id, PageRequest pageRequest) throws IOException, InterruptedException {
        return articleBaseService.getArticleBydCategoryid(id, pageRequest);
    }

    /**
     *
     * @param comment 需要添加的评论
     * @throws IOException
     * 添加评论信息
     */
    @PostMapping("add/comment")
    public String addComment(Comment comment) throws IOException, InterruptedException {
        comment.setCreatetime(new Date());
        return articleBaseService.addComment(comment);
    }

    /**
     *
     * @param id 需要查找的评论id
     * @return
     * @throws IOException
     * 根据id查找评论
     */
    @PostMapping("search/comment/id")
    public Comment searchComment(String id) throws IOException, InterruptedException {
        return articleBaseService.getCommentById(id);
    }

    /**
     *
     * @param articleId 文章id
     * @return
     * @throws IOException
     * 根据文章id查找评论信息
     */
    @PostMapping("search/comment/articleid")
    public PageImpl<Comment> searchCommentByArticleId(String articleId, PageRequest page) throws IOException, InterruptedException {
        return articleBaseService.getCommentByAritcleId(articleId, page);
    }

    /**
     *
     * @param commentId 评论id
     * @return
     * @throws IOException
     * 根据评论id获取评论
     */
    @PostMapping("search/comment/commentid")
    public PageImpl<Comment> searchCommentByCommentId(String commentId, PageRequest page) throws IOException, InterruptedException {
        return articleBaseService.getCommentByCommentId(commentId, page);
    }

    /**
     *
     * @param commentId 评论id
     * @throws IOException
     * 按照id删除评论
     */
    @PostMapping("delete/comment")
    public void deleteCommentById(String commentId) throws IOException, InterruptedException {
        articleBaseService.deleteCommentById(commentId);
    }

    /**
     *
     * @param articleId 文章id
     * @throws IOException
     * 按照文章id删除文章
     */
    @PostMapping("delete/article")
    public void deleteArticleById(String articleId) throws IOException, InterruptedException {
        articleBaseService.deleteArticleById(articleId);
    }


    /**
     *
     * @param article 文章对象
     * @throws IOException
     * 需要删除的文章对象
     */
    @PostMapping("update/article")
    public void updateArticleById(Article article) throws IOException, InterruptedException {
        article.setUpdatetime(new Date());
        articleBaseService.updateArticleEsData(article);
    }

    /**
     *
     * @param comment 需要删除的评论
     * @throws IOException
     * 删除评论
     */
    @PostMapping("update/comment")
    public void updateComment(Comment comment) throws IOException, InterruptedException {
        comment.setUpdatetime(new Date());
        articleBaseService.updateCommentEsData(comment);
    }


    /**
     *
     * @throws IOException
     * 获取父目录编码
     */
    @PostMapping("get/index")
    public List<Index> getParentIndex() throws IOException, InterruptedException {
        return indexService.getParentIndex();
    }

    /**
     *
     * @throws IOException
     * 添加目录
     */
    @PostMapping("add/index")
    public String addIndex(Index index) throws IOException, InterruptedException {
        return indexService.addIndex(index);
    }

    /**
     *
     * @throws IOException
     * 更新目录
     */
    @PostMapping("update/index")
    public boolean updateIndex(Index index) throws IOException, InterruptedException {
        return indexService.updateIndex(index);
    }

    /**
     *
     * @throws IOException
     * 获取某个目录下的子目录
     */
    @PostMapping("get/parentid")
    public List<Index> getParentIdIndex(String parentId) throws IOException, InterruptedException {
        return indexService.getIndexByParentId(parentId);
    }

    /**
     *
     * @throws IOException
     * 删除目录
     */
    @PostMapping("delete/index")
    public boolean deleteIndex(String indexId) throws IOException, InterruptedException {
        return indexService.deleteIndex(indexId);
    }


    /**
     *
     * @throws IOException
     * 获取目录
     */
    @PostMapping("get/indexId")
    public Index getIndxById(String indexId) throws IOException, InterruptedException {
        return indexService.searchIndexById(indexId);
    }


}

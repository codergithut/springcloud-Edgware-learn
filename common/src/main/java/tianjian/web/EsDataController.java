package tianjian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tianjian.domain.client.Article;
import tianjian.domain.client.Comment;
import tianjian.service.ArticleBaseService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("dev/data")
public class EsDataController {

    @Autowired
    ArticleBaseService articleBaseService;

    @PostMapping("/add/article")
    public void addArticle(Article article) throws IOException {
        articleBaseService.addArticle(article);
    }

    @PostMapping("search/article")
    public Article searchArticle(String id) throws IOException {
        return articleBaseService.getArticleById(id);
    }

    @PostMapping("add/comment")
    public void addComment(Comment comment) throws IOException {
        articleBaseService.addComment(comment);
    }

    @PostMapping("search/comment/id")
    public Comment searchComment(String id) throws IOException {
        return articleBaseService.getCommentById(id);
    }

    @PostMapping("search/comment/articleid")
    public List<Comment> searchCommentByArticleId(String articleId) throws IOException {
        return articleBaseService.getCommentByAritcleId(articleId);
    }

    @PostMapping("search/comment/commentid")
    public List<Comment> searchCommentByCommentId(String commentId) throws IOException {
        return articleBaseService.getCommentByCommentId(commentId);
    }

    @PostMapping("delete/comment")
    public void deleteCommentById(String commentId) throws IOException {
        articleBaseService.deleteCommentById(commentId);
    }

    @PostMapping("delete/article")
    public void deleteArticleById(String articleId) throws IOException {
        articleBaseService.deleteArticleById(articleId);
    }


    @PostMapping("update/article")
    public void updateArticleById(Article article) throws IOException {
        article.setUpdatetime(new Date());
        articleBaseService.updateArticleEsData(article);
    }

    @PostMapping("update/comment")
    public void updateComment(Comment comment) throws IOException {
        comment.setUpdatetime(new Date());
        articleBaseService.updateCommentEsData(comment);
    }

    @GetMapping("/test")
    public String helloWorld(Comment comment) throws IOException {
        return "hello";
    }



}

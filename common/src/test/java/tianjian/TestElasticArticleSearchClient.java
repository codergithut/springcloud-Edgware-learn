package tianjian;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.junit.Before;
import org.junit.Test;
import tianjian.domain.client.Article;
import tianjian.domain.client.Comment;
import tianjian.util.EsUtil;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class TestElasticArticleSearchClient {
    RestClient restClient;



    @Before
    public void initRestClient() throws IOException, InterruptedException {
        restClient = RestClient.builder(
                new HttpHost("127.0.0.1", 9200, "http")).build();
        Article article = new Article();
        article.setAuthor("tianjian");
        article.setAnswersid(UUID.randomUUID().toString());
        article.setHtmlcontent("this is test");
        article.setUrl("www.baidu.com");
        article.setRate(1000);
        article.setTitle("titile");
        article.setDescribe("这个是测试用例");
        EsUtil.addBeanToEs("article/freezone", article, restClient);


        Comment comment = new Comment();
        comment.setUserid("路人甲");
        comment.setType("资源");
        comment.setCommentcontent("我评论了楼主的文章");
        comment.setReplyid(article.getAnswersid());
        comment.setCreatetime(new Date());
        comment.setUpdatetime(new Date());
        comment.setCommentid(UUID.randomUUID().toString());
        EsUtil.addBeanToEs("comment/abusivearea", comment, restClient);

        Comment comment00 = new Comment();
        comment00.setUserid("路人乙");
        comment00.setType("评论");
        comment00.setCommentcontent("我评论了甲的回复");
        comment00.setReplyid(comment.getCommentid());
        comment00.setCreatetime(new Date());
        comment00.setUpdatetime(new Date());
        comment00.setCommentid(UUID.randomUUID().toString());
        EsUtil.addBeanToEs("comment/abusivearea", comment00, restClient);

        Comment comment10 = new Comment();
        comment10.setUserid("路人丙");
        comment10.setType("评论");
        comment10.setCommentcontent("我评论了丙的回复");
        comment10.setReplyid(comment00.getCommentid());
        comment10.setCreatetime(new Date());
        comment10.setUpdatetime(new Date());
        comment10.setCommentid(UUID.randomUUID().toString());
        EsUtil.addBeanToEs("comment/abusivearea", comment10, restClient);
    }


    @Test
    public void testElasticSearchClient() throws IOException, InterruptedException {

        restClient = RestClient.builder(
                new HttpHost("127.0.0.1", 9200, "http")).build();


//        ElasticSearchPage<Comment> commentElasticSearchPage = new ElasticSearchPage<Comment>();

//        commentElasticSearchPage = EsUtil.searchBeanFrommEs("comment/abusivearea", "5a7cc183-c9e0-4399-bc15-007b293be679", "replyid", restClient,commentElasticSearchPage, Comment.class);
//
//        ElasticSearchPage<Comment> commentElasticSearchPage1 = new ElasticSearchPage<Comment>();
//        commentElasticSearchPage1.setCount(1);
//        commentElasticSearchPage1 =EsUtil.searchBeanFrommEs("comment/abusivearea", "714f83f6-f612-4e17-991b-43d22fae22f4", "replyid", restClient,commentElasticSearchPage1, Comment.class);
//
//        ElasticSearchPage<Article> articleElasticSearchPage = new ElasticSearchPage<Article>();
//        articleElasticSearchPage.setCount(1);
//        articleElasticSearchPage =EsUtil.searchBeanFrommEs("article/freezone", "a27da27f-29ff-4ee2-8c68-c3d48da9db94", "answersid", restClient,articleElasticSearchPage, Article.class);
//

        System.out.println("xx");

    }
}
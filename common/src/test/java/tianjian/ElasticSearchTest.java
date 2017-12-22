package tianjian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tianjian.domain.Article;
import tianjian.domain.Author;
import tianjian.domain.Tutorial;
import tianjian.service.ArticleSearchRepository;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ElasticSearchTest {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;
    @Test
    public void testSaveArticleIndex(){
        Author author=new Author();
        author.setId(234L);
        author.setName("tianshouzhi");
        author.setRemark("java developer");

        Tutorial tutorial=new Tutorial();
        tutorial.setId(42l);
        tutorial.setName("elastic search");

        Article article =new Article();
        article.setId(243L);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setTutorial(tutorial);
        article.setAuthor(author);
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(24L);

        articleSearchRepository.save(article);
    }

}
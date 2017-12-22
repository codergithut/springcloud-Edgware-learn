package tianjian.service;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import tianjian.domain.Article;

//泛型的参数分别是实体类型和主键类型
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long>{

}
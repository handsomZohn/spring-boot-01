package com.zohn.springboot01.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
* @Description: 文章的仓库
* @Author: zohn
* @CreateDate: 2019/4/27 6:48
* @Version: 1.0
*/
@Component
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
}

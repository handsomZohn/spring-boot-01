package com.zohn.springboot01.es;

import com.zohn.springboot01.domain.JsonData;
import com.zohn.springboot01.utils.JsonUtils;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: Article前端控制器
 * @Author: zohn
 * @CreateDate: 2019/4/27 7:19
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * @Description 保存文章
     * @Author zohn
     * @Date 2019/4/27 7:33
     * @Param [id, title]
     * @Return java.lang.Object
     */
    @GetMapping("/save")
    public Object save(long id, String title) {
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);

        article.setContent("Spring-boot整合elasticSearch，文档在spring-boot的doc中。");
        article.setSummary("es与sb");
        article.setPv(110);

        articleRepository.save(article);

        return JsonData.buildSuccess();
    }

    /**
     * @Description 搜索文章--通过标题
     * @Author zohn
     * @Date 2019/4/27 7:32
     * @Param [title]
     * @Return java.lang.Object
     */
    @GetMapping("/search")
    public Object search(String title) {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title);
        Iterable<Article> articles = articleRepository.search(queryBuilder);
        return JsonData.buildSuccess(articles);
    }

    /**
     * @Description 搜索文章--内容，在多个字段上搜索，可以是title，summary, etc.
     * @Author zohn
     * @Date 2019/4/27 9:58
     * @Param [qr]
     * @Return java.lang.Object
     */
    @GetMapping("/multiSearch")
    public Object multiSearch(String qr) {
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders
                .multiMatchQuery(qr, "title", "summary", "pv", "content");
        Iterable<Article> articles = articleRepository.search(multiMatchQueryBuilder);
        return JsonData.buildSuccess(articles);
    }
}
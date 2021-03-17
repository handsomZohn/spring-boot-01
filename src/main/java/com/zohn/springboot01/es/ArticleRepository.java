package com.zohn.springboot01.es;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
* @Description: 文章的仓库
* @Author: zohn
* @CreateDate: 2019/4/27 6:48
* @Version: 1.0
*/
@Component
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
    @Override
    default <S extends Article> S index(S s) {
        return null;
    }

    @Override
    default Iterable<Article> search(QueryBuilder queryBuilder) {
        return null;
    }

    @Override
    default Page<Article> search(QueryBuilder queryBuilder, Pageable pageable) {
        return null;
    }

    @Override
    default Page<Article> search(SearchQuery searchQuery) {
        return null;
    }

    @Override
    default Page<Article> searchSimilar(Article article, String[] strings, Pageable pageable) {
        return null;
    }

    @Override
    default void refresh() {

    }

    @Override
    default Class<Article> getEntityClass() {
        return null;
    }

    @Override
    default Iterable<Article> findAll(Sort sort) {
        return null;
    }

    @Override
    default Page<Article> findAll(Pageable pageable) {
        return null;
    }

    @Override
    default <S extends Article> S save(S s) {
        return null;
    }

    @Override
    default <S extends Article> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    default Optional<Article> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Article> findAll() {
        return null;
    }

    @Override
    default Iterable<Article> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Article article) {

    }

    @Override
    default void deleteAll(Iterable<? extends Article> iterable) {

    }

    @Override
    default void deleteAll() {

    }
}

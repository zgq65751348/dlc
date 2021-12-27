package com.ark.valguero.repository;

import com.ark.valguero.document.Article;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * TODO
 *
 * @author 巴黎欧莱雅
 * @version 1.0
 * @date 2021/12/27 17:52
 * @e-mail SpringCloud2.0@outlook.com
 */
public interface ArticleRepository extends ReactiveMongoRepository<Article, Long> {
}

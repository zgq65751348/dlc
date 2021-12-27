package com.ark.valguero.runner;

import com.ark.valguero.document.Article;
import com.ark.valguero.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * TODO
 *
 * @author 巴黎欧莱雅
 * @version 1.0
 * @date 2021/12/27 17:59
 * @e-mail SpringCloud2.0@outlook.com
 */
@Component
public class ApplicationRunnerExecutor {

    @Autowired
    private ArticleRepository articleRepository;

    @Bean
    public ApplicationRunner init(){
        Object[][] data = {
                {"sea", "Andrew", 300.12, "NDK"},
                {"creek", "Andrew", 100.75, "Piranha"},
                {"loaner", "Andrew", 75, "Necky"}
        };

        return args -> {
            articleRepository
                    .deleteAll()
                    .thenMany(
                            Flux
                                    .just(data)
                                    .map(array -> {
                                        return new Article((String) array[0], (String) array[1], (Number) array[2], (String) array[3]);
                                    })
                                    .flatMap(articleRepository::save)
                    )
                    .thenMany(articleRepository.findAll())
                    .subscribe(article -> System.out.println("saving " + article.toString()));
        };
    }
}

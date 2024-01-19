package tn.slim.msarticle.mappers.services;

//
//}


import entities.ArticleDto;
import entities.StockDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import tn.slim.msarticle.client.StockClient;
import tn.slim.msarticle.entities.Article;
import tn.slim.msarticle.mappers.ArticleMapper;
import tn.slim.msarticle.repositories.ArticleRepository;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class IArticleImp  implements  IArticleService {


    private final ArticleRepository articleRepository ;
    private final StockClient stockClient;

    @Override
    public Article createArticle(Article article){
        article.setCreatedAt(LocalDate.now());
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Map<Object,Object> fields , Long id){

        Optional<Article> article=articleRepository.findById(id);
        Assert.isTrue(article.isPresent(),"no article");


        fields.forEach((key,value)->{

            Field field = ReflectionUtils.findField(Article.class,(String) key);
            field.setAccessible(true);

            ReflectionUtils.setField(field,article ,value);
        });


        return  articleRepository.save(article.get()) ;

    }
    @Override
    public Article addArticle(Article article) {
        article.setCreatedAt(LocalDate.now());
        return articleRepository.save(article);
    }


    @Override
    public Boolean removeArticle(Article article) {
        return null;
    }

    @Override
    public ArticleDto findArticleById(Long articleId) {

        Optional<Article>article =articleRepository.findById(articleId);
        Assert.isTrue(article.isPresent(),"no article");

        StockDto stockDto = stockClient.getStockById(article.get().getIdStock());

        return ArticleMapper.mapToDto( article.get(),stockDto );

    }

    @Override
    public List<Article> retrieveAllArticle() {
        return null;
    }



}

package tn.slim.msarticle.mappers.services;






import entities.ArticleDto;
import tn.slim.msarticle.entities.Article;

import java.util.List;
import java.util.Map;

public interface IArticleService {

    Article createArticle (Article article);

    Article updateArticle(Map<Object,Object> fields , Long id);

    Article addArticle(Article article);

    Boolean removeArticle (Article article);


    ArticleDto findArticleById(Long articleId);

    List<Article> retrieveAllArticle();







}

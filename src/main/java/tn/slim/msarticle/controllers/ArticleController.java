package tn.slim.msarticle.controllers;
import entities.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.slim.msarticle.entities.Article;
import tn.slim.msarticle.mappers.services.IArticleService;


import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("article")
public class ArticleController {

     private final IArticleService articleService;

    @PatchMapping("{id}")
    Article updateArticle(
            @RequestBody Map<Object, Object> fields,
            @PathVariable Long id
    ) {
        return articleService.updateArticle(fields, id);
    }

    @PostMapping("/add")
    public Article addArticle(@RequestBody Article c) {
        return articleService.addArticle(c);
    }
    @GetMapping("/find/{id}")
    @ResponseBody
    public ArticleDto findArticleById(@PathVariable ("id") Long id) {
        return articleService.findArticleById(id);
    }



}


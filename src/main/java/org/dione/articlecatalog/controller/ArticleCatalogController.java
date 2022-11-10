package org.dione.articlecatalog.controller;

import org.dione.articlecatalog.model.Article;
import org.dione.articlecatalog.repository.ArticleRepository;
import org.dione.articlecatalog.repository.SaleRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("**")
public class ArticleCatalogController {
    private final ArticleRepository articleRepository;
    private final SaleRepository saleRepository;

    public ArticleCatalogController(ArticleRepository articleRepository, SaleRepository saleRepository) {
        this.articleRepository = articleRepository;
        this.saleRepository = saleRepository;
    }

    @GetMapping("/allArticle")
    public List<Article> findAllArticles(){
        return articleRepository.findAll();
    }
}

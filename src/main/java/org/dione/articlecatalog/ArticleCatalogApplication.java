package org.dione.articlecatalog;

import org.dione.articlecatalog.service.IArticleCatalogInitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArticleCatalogApplication implements CommandLineRunner {

    private final IArticleCatalogInitService iArticleCatalogInitService;

    public ArticleCatalogApplication(IArticleCatalogInitService iArticleCatalogInitService) {
        this.iArticleCatalogInitService = iArticleCatalogInitService;
    }

    public static void main(String[] args) {

        SpringApplication.run(ArticleCatalogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        iArticleCatalogInitService.initArticles();
        iArticleCatalogInitService.initSale();
        iArticleCatalogInitService.initUsers();
        iArticleCatalogInitService.initRetailSale();
    }
}

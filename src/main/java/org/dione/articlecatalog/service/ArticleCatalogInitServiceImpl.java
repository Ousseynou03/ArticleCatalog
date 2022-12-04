package org.dione.articlecatalog.service;

import org.dione.articlecatalog.enums.CreditStatus;
import org.dione.articlecatalog.model.Article;
import org.dione.articlecatalog.model.RetailSale;
import org.dione.articlecatalog.model.Sale;
import org.dione.articlecatalog.model.User;
import org.dione.articlecatalog.repository.ArticleRepository;
import org.dione.articlecatalog.repository.RetailSaleRepository;
import org.dione.articlecatalog.repository.SaleRepository;
import org.dione.articlecatalog.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Transactional
public class ArticleCatalogInitServiceImpl implements IArticleCatalogInitService {

    private final SaleRepository saleRepository;
    private final RetailSaleRepository retailSaleRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public ArticleCatalogInitServiceImpl(SaleRepository saleRepository, RetailSaleRepository retailSaleRepository,
            UserRepository userRepository, ArticleRepository articleRepository) {
        this.saleRepository = saleRepository;
        this.retailSaleRepository = retailSaleRepository;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public void initUsers() {
        Stream.of("Dione", "Ousseynou", "Weuz").forEach(usr -> {
            User user = new User();
            user.setFirstName(usr);
            user.setPassword(UUID.randomUUID().toString());
            userRepository.save(user);
        });
    }

    @Override
    public void initArticles() {

        Stream.of("Coffe", "Kits", "Phone", "Chemise", "feuteille").forEach(art -> {
            Article article = new Article();
            article.setCodeArticle(UUID.randomUUID().toString());
            article.setDesignation(art);
            articleRepository.save(article);
        });
    }

    @Override
    public void initSale() {
        Sale sale = new Sale();
        sale.setAdvance(Math.random() * 1000);
        sale.setCustomer("Dione");
        sale.setDelivery(Math.random() * 100);
        sale.setCreditStatus(Math.random() > 0.5 ? CreditStatus.REGLER : CreditStatus.EN_ATTENTE);
        sale.setTotal(sale.getAdvance() - sale.getDelivery());
        saleRepository.save(sale);
    }

    @Override
    public void initRetailSale() {
        articleRepository.findAll().forEach(artic -> {
            saleRepository.findAll().forEach(sal -> {
                RetailSale retailSale = new RetailSale();
                retailSale.setSale(sal);
                retailSale.setArticle(artic);
                retailSale.setQuantityOrder(2);
                retailSale.setDateVente(new Date());
                retailSaleRepository.save(retailSale);
            });
        });
    }
}

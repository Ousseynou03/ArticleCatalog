package org.dione.articlecatalog.controller;

import org.dione.articlecatalog.enums.CreditStatus;
import org.dione.articlecatalog.model.Article;
import org.dione.articlecatalog.model.RetailSale;
import org.dione.articlecatalog.model.Sale;
import org.dione.articlecatalog.model.User;
import org.dione.articlecatalog.repository.ArticleRepository;
import org.dione.articlecatalog.repository.RetailSaleRepository;
import org.dione.articlecatalog.repository.SaleRepository;
import org.dione.articlecatalog.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("**")
public class ArticleCatalogController {
    private final ArticleRepository articleRepository;
    private final SaleRepository saleRepository;
    private final UserRepository userRepository;
    private final RetailSaleRepository retailSaleRepository;

    public ArticleCatalogController(ArticleRepository articleRepository, SaleRepository saleRepository, UserRepository userRepository, RetailSaleRepository retailSaleRepository) {
        this.articleRepository = articleRepository;
        this.saleRepository = saleRepository;
        this.userRepository = userRepository;
        this.retailSaleRepository = retailSaleRepository;
    }

    //Méthode de récupération de tous les articles
    @GetMapping("/allArticles")
    public List<Article> findAllArticles(){
        return articleRepository.findAll();
    }

    //Méthode de récupération de tous les users
    @GetMapping("/allUsers")
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    //Méthode de récupération de tous les ventes
    @GetMapping("allSales")
    public List<Sale> findAllSale(){
        return saleRepository.findAll();
    }

    //Méthode de récupération de tous les détails ventes
    @GetMapping("/allRetailsSales")
    public List<RetailSale> retailSaleList(){
        return retailSaleRepository.findAll();
    }


    //Méthodes pour récupérer un article sachant son id
    @GetMapping("/article/{id}")
    public Article findArticleById(@PathVariable Long id){
        return articleRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Artcile not found "));
    }

    //Méthodes pour récupérer un user sachant son id
    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id){
        return userRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User not found "));
    }

    //Méthodes pour récupérer un sale sachant son id
    @GetMapping("/sale/{id}")
    public Sale findSaleById(@PathVariable Long id){
        return saleRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Sale not found "));
    }

    //Méthodes pour récupérer un retailsale sachant son id
    @GetMapping("/retailsale/{id}")
    public RetailSale findRetailSaleById(@PathVariable Long id){
        return retailSaleRepository.findById(id).
                orElseThrow(()-> new RuntimeException("RetailSale not found "));
    }

    //Méthode pour ajouter un artcile dans la base de données
    @PostMapping("/addArticle")
    public Article addArticle(@RequestBody Article article){
        return  articleRepository.save(article);
    }

    //Méthode pour ajouter un user dans la base de données
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        user.setPassword(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    //Méthode pour ajouter une vente dans la base de données
    @PostMapping("/addSale")
    public Sale addSale(@RequestBody Sale sale){
        sale.setAdvance(Math.random()*100000);
        sale.setDelivery(Math.random()*1000);
        sale.setCreditStatus(Math.random()>0.5? CreditStatus.REGLER:CreditStatus.EN_ATTENTE);
        sale.setTotal(sale.getAdvance() - sale.getDelivery());
        return saleRepository.save(sale);
    }

    //Méthode pour la modification d'un article
    @PutMapping("/updateArticle/{id}")
    public Article updateArticle(@RequestBody Article article,@PathVariable Long id){
        article.setIdArticle(id);
        return articleRepository.save(article);
    }
    //Méthode pour la modification d'un user
    @PutMapping("/updateUser/{id}")
    public User updateUser(@RequestBody User user,@PathVariable Long id){
        user.setIdUser(id);
        return userRepository.save(user);
    }

    //Méthode pour la modification d'une vente
    @PutMapping("/updateSale/{id}")
    public Sale updateSale(@RequestBody Sale sale,@PathVariable Long id){
        sale.setIdSale(id);
        return saleRepository.save(sale);
    }

    //Méthode pour la suppression d'un article
    @DeleteMapping("/deleteArticle/{id}")
    public void deleteArticle(@PathVariable Long id){
        articleRepository.deleteById(id);
    }

    //Méthode pour la suppression d'un user
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    //Méthode pour la suppression d'une vente
    @DeleteMapping("/deleteSale/{id}")
    public void deleteSale(@PathVariable Long id){
        saleRepository.deleteById(id);
    }
}


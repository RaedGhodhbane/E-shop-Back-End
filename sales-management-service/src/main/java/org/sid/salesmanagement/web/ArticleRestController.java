package org.sid.salesmanagement.web;

import org.sid.salesmanagement.entities.Article;
import org.sid.salesmanagement.repositories.ArticleRepository;
import org.sid.salesmanagement.repositories.CategorieRepository;
import org.sid.salesmanagement.repositories.MarqueRepository;
import org.sid.salesmanagement.services.LivraisonRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

public class ArticleRestController {
    private final ArticleRepository articleRepository;
    private final MarqueRepository marqueRepository;
    private final CategorieRepository categorieRepository;
    private final LivraisonRestClient livraisonRestClient;

    public ArticleRestController(ArticleRepository articleRepository, MarqueRepository marqueRepository, CategorieRepository categorieRepository, LivraisonRestClient livraisonRestClient) {
        this.articleRepository = articleRepository;
        this.marqueRepository = marqueRepository;
        this.categorieRepository = categorieRepository;
        this.livraisonRestClient = livraisonRestClient;
    }

    @GetMapping("/fullArticle/{id}")
    public List<Article> articlesByLivraison(@PathVariable Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            Long livraisonId = article.getLivraison().getId();

            // Supposons que vous avez une méthode dans LivraisonRestClient pour obtenir les articles d'une livraison
            List<Article> articles = livraisonRestClient.findLivraisonById(id);

            return articles;
        } else {
            // Gérer le cas où l'article avec l'id donné n'existe pas
            throw new RuntimeException("Article non trouvé avec l'id " + id);
        }
    }
}

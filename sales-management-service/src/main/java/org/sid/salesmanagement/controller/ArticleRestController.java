package org.sid.salesmanagement.controller;

import org.sid.salesmanagement.security.dto.ArticleDTO;
import org.sid.salesmanagement.security.mapper.ArticleMapper;
import org.sid.salesmanagement.security.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleMapper articleMapper; // Injection du mapper

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {
        // Utiliser le service pour créer l'article
        ArticleDTO createdArticle = articleService.createArticle(articleDTO);
        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable("id") Long id) {
        // Utiliser le service pour obtenir l'article par ID
        ArticleDTO articleDTO = articleService.getArticleById(id);
        return new ResponseEntity<>(articleDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        // Utiliser le service pour obtenir tous les articles
        List<ArticleDTO> articles = articleService.getAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable("id") Long id, @RequestBody ArticleDTO articleDTO) {
        // Utiliser le service pour mettre à jour l'article
        ArticleDTO updatedArticle = articleService.updateArticle(id, articleDTO);
        return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        // Utiliser le service pour supprimer l'article
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

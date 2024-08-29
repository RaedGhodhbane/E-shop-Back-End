package org.sid.salesmanagement.security.service;

import org.modelmapper.ModelMapper;
import org.sid.salesmanagement.entities.Article;
import org.sid.salesmanagement.repository.ArticleRepository;
import org.sid.salesmanagement.security.dto.ArticleDTO;
import org.sid.salesmanagement.security.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper; // Injection du mapper

    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = articleMapper.articleDTOToArticle(articleDTO);
        Article savedArticle = articleRepository.save(article);
        return articleMapper.articleToArticleDTO(savedArticle);
    }

    public ArticleDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        return articleMapper.articleToArticleDTO(article);
    }

    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(articleMapper::articleToArticleDTO)
                .collect(Collectors.toList());
    }

    public ArticleDTO updateArticle(Long id, ArticleDTO articleDTO) {
        Article existingArticle = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        Article updatedArticle = articleMapper.articleDTOToArticle(articleDTO);
        updatedArticle.setId(id); // Ensure the ID is preserved for updates
        updatedArticle = articleRepository.save(updatedArticle);
        return articleMapper.articleToArticleDTO(updatedArticle);
    }

    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        articleRepository.delete(article);
    }
}

package org.sid.salesmanagement.services;

import org.sid.salesmanagement.entities.Article;
import org.sid.salesmanagement.models.Livraison;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "USERSANDLOGISTICS-MANAGEMENT-SERVICE")
public interface LivraisonRestClient {
    @GetMapping(path = "/livraisons/{id}")
    List<Article> findLivraisonById(@PathVariable Long id);
}

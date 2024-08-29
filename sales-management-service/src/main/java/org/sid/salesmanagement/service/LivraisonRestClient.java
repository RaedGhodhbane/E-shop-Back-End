package org.sid.salesmanagement.service;

import org.sid.salesmanagement.entities.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "usersAndLogistics-management-service")
public interface LivraisonRestClient {
    @GetMapping(path = "/livraisons/{id}")
    List<Article> findLivraisonById(@PathVariable Long id);
}

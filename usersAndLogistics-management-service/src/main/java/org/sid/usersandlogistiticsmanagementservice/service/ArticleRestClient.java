package org.sid.usersandlogistiticsmanagementservice.service;

import org.sid.usersandlogistiticsmanagementservice.model.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ArticleRestClient {
    @GetMapping(path = "/articles/{id}")
    Article findArticleById(@PathVariable Long id);
}

package org.sid.salesmanagement.repository;

import org.sid.salesmanagement.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}

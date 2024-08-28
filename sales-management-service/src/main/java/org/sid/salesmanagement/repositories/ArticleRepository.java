package org.sid.salesmanagement.repositories;

import org.sid.salesmanagement.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}

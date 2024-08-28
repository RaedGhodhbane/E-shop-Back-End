package org.sid.salesmanagement.repositories;

import org.sid.salesmanagement.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}

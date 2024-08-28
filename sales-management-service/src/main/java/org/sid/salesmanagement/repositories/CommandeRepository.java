package org.sid.salesmanagement.repositories;

import org.sid.salesmanagement.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}

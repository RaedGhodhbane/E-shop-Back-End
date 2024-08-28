package org.sid.salesmanagement.repositories;

import org.sid.salesmanagement.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}

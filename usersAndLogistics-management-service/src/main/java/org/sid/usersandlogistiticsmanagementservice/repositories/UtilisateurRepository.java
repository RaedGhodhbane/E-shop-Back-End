package org.sid.usersandlogistiticsmanagementservice.repositories;

import org.sid.usersandlogistiticsmanagementservice.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}

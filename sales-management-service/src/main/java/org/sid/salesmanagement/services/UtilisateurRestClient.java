package org.sid.salesmanagement.services;

import org.sid.salesmanagement.models.Utilisateur;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UtilisateurRestClient {
    @GetMapping(path = "/users/{id}")
    Utilisateur findUtilisateurById(@PathVariable Integer id);
}

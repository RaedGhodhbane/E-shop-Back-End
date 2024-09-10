package org.sid.usersandlogistiticsmanagementservice.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.usersandlogistiticsmanagementservice.entities.Adresse;
import org.sid.usersandlogistiticsmanagementservice.model.Commande;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class UtilisateurDTO {
    private String mail;
    private String login;
    private String mdp;
    private String sexe;
    private String nom;
    private String prenom;
    private String tel;
    private String image;
    private List<Adresse> adresses;
    private Commande commande;
}

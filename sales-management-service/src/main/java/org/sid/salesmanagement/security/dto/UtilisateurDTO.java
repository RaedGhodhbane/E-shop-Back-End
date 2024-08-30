package org.sid.salesmanagement.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}

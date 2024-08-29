package org.sid.salesmanagement.model;

import jakarta.persistence.OneToMany;
import lombok.Data;
import org.sid.salesmanagement.entities.Commande;

@Data
public class Utilisateur {
    private int id;
    private String mail;
    private String login;
    private String mdp;
    private String sexe;
    private String nom;
    private String prenom;
    private String tel;
    private String image;
    @OneToMany(mappedBy = "utilisateur")
    private Commande commande;
}

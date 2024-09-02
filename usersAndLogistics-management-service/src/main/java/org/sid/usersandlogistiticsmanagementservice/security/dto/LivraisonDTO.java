package org.sid.usersandlogistiticsmanagementservice.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.usersandlogistiticsmanagementservice.entities.ModeLivraison;
import org.sid.usersandlogistiticsmanagementservice.model.Article;
import org.sid.usersandlogistiticsmanagementservice.model.Boutique;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class LivraisonDTO {
    private Date date;
    private String description;
    private List<ModeLivraison> modeLivraison;
    private Article article;
    private Boutique boutique;
}

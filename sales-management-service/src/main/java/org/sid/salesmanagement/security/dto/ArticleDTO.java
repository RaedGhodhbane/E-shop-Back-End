package org.sid.salesmanagement.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ArticleDTO {
    private String design;
    private float price;
    private double qteStock;
    private int discountRate;
    private String image;
    private String description;
    private MarqueDTO marque;
    private CategorieDTO categorie;
    private LivraisonDTO livraison;
}

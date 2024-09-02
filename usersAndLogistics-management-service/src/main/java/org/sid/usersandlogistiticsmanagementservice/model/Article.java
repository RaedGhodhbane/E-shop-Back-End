package org.sid.usersandlogistiticsmanagementservice.model;

import lombok.Data;

@Data
public class Article {
    private Long id;
    private String design;
    private Float price;
    private Double qteStock;
    private Float tauxTVA;
    private int tauxRemise;
    private String image;
    private String description;
}

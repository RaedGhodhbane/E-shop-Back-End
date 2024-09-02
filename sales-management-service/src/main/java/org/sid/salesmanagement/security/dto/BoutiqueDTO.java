package org.sid.salesmanagement.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class BoutiqueDTO {
    private String lib;
    private String adresse;
    private String tel;
    private String email;
    private String description;
    private LivraisonDTO livraisonDTO;
}

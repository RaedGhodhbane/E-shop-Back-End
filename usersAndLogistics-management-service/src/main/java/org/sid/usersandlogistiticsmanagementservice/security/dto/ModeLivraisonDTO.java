package org.sid.usersandlogistiticsmanagementservice.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.usersandlogistiticsmanagementservice.entities.Livraison;

@Data @NoArgsConstructor @AllArgsConstructor
public class ModeLivraisonDTO {
    private String lib;
    private String description;

    private Livraison livraison;
}

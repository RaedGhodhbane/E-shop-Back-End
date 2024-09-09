package org.sid.usersandlogistiticsmanagementservice.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.usersandlogistiticsmanagementservice.entities.Utilisateur;

@Data @NoArgsConstructor @AllArgsConstructor
public class AdresseDTO {
    private String ville;
    private String codePostal;

    private String province;

    private Utilisateur utilisateur;
}

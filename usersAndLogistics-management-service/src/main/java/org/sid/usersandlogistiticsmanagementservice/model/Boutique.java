package org.sid.usersandlogistiticsmanagementservice.model;

import lombok.Data;

@Data
public class Boutique {
    private Long id;
    private String lib;
    private String adresse;
    private String tel;
    private String mail;
    private String description;
}

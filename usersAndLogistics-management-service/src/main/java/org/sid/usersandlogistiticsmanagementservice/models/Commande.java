package org.sid.usersandlogistiticsmanagementservice.models;

import lombok.Data;

import java.util.Date;

@Data
public class Commande {
    private Long id;
    private Date date;
    private String description;
}

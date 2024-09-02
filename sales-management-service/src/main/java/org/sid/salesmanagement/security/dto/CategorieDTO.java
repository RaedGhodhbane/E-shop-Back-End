package org.sid.salesmanagement.security.dto;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class CategorieDTO {
    private String lib;
    private ArticleDTO articleDTO;

}

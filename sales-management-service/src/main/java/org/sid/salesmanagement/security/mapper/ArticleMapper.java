package org.sid.salesmanagement.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.entities.Article;
import org.sid.salesmanagement.security.dto.ArticleDTO;

@Mapper
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    ArticleDTO articleToArticleDTO(Article article);

    Article articleDTOToArticle(ArticleDTO articleDTO);
}

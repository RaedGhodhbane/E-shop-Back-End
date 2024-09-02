package org.sid.salesmanagement.configuration;

import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.security.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ArticleMapper articleMapper() {
        return Mappers.getMapper(ArticleMapper.class);
    }
    @Bean
    public MarqueMapper marqueMapper() {return Mappers.getMapper(MarqueMapper.class);}

    @Bean
    public BoutiqueMapper boutiqueMapper() {return Mappers.getMapper(BoutiqueMapper.class);}

    @Bean
    public CategorieMapper categorieMapper() {return Mappers.getMapper(CategorieMapper.class);}

    @Bean
    public ChariotMapper chariotMapper() {return Mappers.getMapper(ChariotMapper.class);}
}


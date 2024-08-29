package org.sid.salesmanagement.configuration;

import org.mapstruct.factory.Mappers;
import org.sid.salesmanagement.security.mapper.ArticleMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ArticleMapper articleMapper() {
        return Mappers.getMapper(ArticleMapper.class);
    }
}


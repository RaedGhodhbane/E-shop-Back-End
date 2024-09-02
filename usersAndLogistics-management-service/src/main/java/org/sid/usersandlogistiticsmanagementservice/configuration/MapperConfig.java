package org.sid.usersandlogistiticsmanagementservice.configuration;

import org.mapstruct.factory.Mappers;
import org.sid.usersandlogistiticsmanagementservice.security.mapper.LivraisonMapper;
import org.sid.usersandlogistiticsmanagementservice.security.mapper.ModeLivraisonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public LivraisonMapper livraisonMapper() {
        return Mappers.getMapper(LivraisonMapper.class);
    }

    @Bean
    public ModeLivraisonMapper modeLivraisonMapper() {
        return Mappers.getMapper(ModeLivraisonMapper.class);
    }
}


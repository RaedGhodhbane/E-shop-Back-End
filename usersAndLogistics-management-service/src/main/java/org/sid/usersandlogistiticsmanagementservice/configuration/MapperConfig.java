package org.sid.usersandlogistiticsmanagementservice.configuration;

import org.mapstruct.factory.Mappers;
import org.sid.usersandlogistiticsmanagementservice.security.mapper.*;
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
    @Bean
    public AdresseMapper adresseMapper() {return Mappers.getMapper(AdresseMapper.class);}

    @Bean
    public HabilitationMapper habilitationMapper() {return Mappers.getMapper(HabilitationMapper.class);}

    @Bean
    public UtilisateurMapper utilisateurMapper() {return Mappers.getMapper(UtilisateurMapper.class);}
}



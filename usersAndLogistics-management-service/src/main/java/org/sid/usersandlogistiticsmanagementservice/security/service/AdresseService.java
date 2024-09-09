package org.sid.usersandlogistiticsmanagementservice.security.service;

import org.sid.usersandlogistiticsmanagementservice.security.dto.AdresseDTO;

import java.util.List;

public interface AdresseService {
    AdresseDTO createAdresse(AdresseDTO adresseDTO);

    AdresseDTO getAdresseById(Integer id);

    List<AdresseDTO> getAllAdresses();

    AdresseDTO updateAdresse(Integer id, AdresseDTO adresseDTO);

    void deleteAdresse(Integer id);
}

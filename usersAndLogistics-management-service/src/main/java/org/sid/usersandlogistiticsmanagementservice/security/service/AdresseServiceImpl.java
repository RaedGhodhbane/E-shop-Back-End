package org.sid.usersandlogistiticsmanagementservice.security.service;

import org.sid.usersandlogistiticsmanagementservice.entities.Adresse;
import org.sid.usersandlogistiticsmanagementservice.repository.AdresseRepository;
import org.sid.usersandlogistiticsmanagementservice.security.dto.AdresseDTO;
import org.sid.usersandlogistiticsmanagementservice.security.mapper.AdresseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseServiceImpl implements AdresseService {

    @Autowired
    private AdresseRepository adresseRepository;

    @Autowired
    private AdresseMapper adresseMapper;

    public AdresseDTO createAdresse(AdresseDTO adresseDTO) {
        Adresse adresse = adresseMapper.adresseDTOToAdresse(adresseDTO);
        Adresse savedAdresse = adresseRepository.save(adresse);
        return adresseMapper.adresseToAdresseDTO(savedAdresse);
    }

    public AdresseDTO getAdresseById(Integer id) {
        Adresse adresse = adresseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adresse not found"));
        return adresseMapper.adresseToAdresseDTO(adresse);
    }

    public List<AdresseDTO> getAllAdresses() {
        return adresseRepository.findAll().stream()
                .map(adresseMapper::adresseToAdresseDTO)
                .toList();
    }

    public AdresseDTO updateAdresse(Integer id, AdresseDTO adresseDTO) {
        Adresse existingAdresse = adresseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adresse not found"));
        Adresse updatedAdresse = adresseMapper.adresseDTOToAdresse(adresseDTO);
        updatedAdresse.setId(id);
        updatedAdresse = adresseRepository.save(updatedAdresse);
        return adresseMapper.adresseToAdresseDTO(updatedAdresse);
    }

    public void deleteAdresse(Integer id) {
        Adresse adresse = adresseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adresse not found"));
        adresseRepository.delete(adresse);
    }

}

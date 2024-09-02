package org.sid.salesmanagement.security.service;

import org.sid.salesmanagement.entities.Categorie;
import org.sid.salesmanagement.repository.CategorieRepository;
import org.sid.salesmanagement.security.dto.CategorieDTO;
import org.sid.salesmanagement.security.mapper.CategorieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieService {

    //Injection des dépendences

    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private CategorieMapper categorieMapper;
    public CategorieDTO createCategorie(CategorieDTO categorieDTO) {
        Categorie categorie = categorieMapper.categorieDTOToCategorie(categorieDTO);
        Categorie savedCategorie = categorieRepository.save(categorie);
        return categorieMapper.categorieToCategorieDTO(savedCategorie);
    }

    public CategorieDTO getCategorieById(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categorie not found"));
        return categorieMapper.categorieToCategorieDTO(categorie);
    }

    public List<CategorieDTO> getAllCategories() {
        return categorieRepository.findAll().stream()
                .map(categorieMapper::categorieToCategorieDTO)
                .collect(Collectors.toList());
    }

    public CategorieDTO updateCategorie(Long id, CategorieDTO categorieDTO) {
        Categorie existingCategorie = categorieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categorie not found"));
        Categorie updatedCategorie = categorieMapper.categorieDTOToCategorie(categorieDTO);
        updatedCategorie.setId(id);
        updatedCategorie = categorieRepository.save(updatedCategorie);
        return categorieMapper.categorieToCategorieDTO(updatedCategorie);
    }

    public void deleteCategorie(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categorie not found"));
        categorieRepository.delete(categorie);
    }
}

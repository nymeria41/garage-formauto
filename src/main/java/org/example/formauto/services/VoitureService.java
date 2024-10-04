package org.example.formauto.services;

import org.example.formauto.DTO.VoitureDTO;
import org.example.formauto.entities.Voiture;
import org.example.formauto.repositories.VoitureRepository;
import org.example.formauto.utils.VoitureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    // Méthode pour récupérer toutes les voitures sous forme de DTO
    public List<VoitureDTO> findAll() {
        return voitureRepository.findAll().stream()
                .map(VoitureMapper::toDto)
                .collect(Collectors.toList());
    }

    // Méthode pour trouver une voiture par ID et retourner un DTO
    public Optional<VoitureDTO> findById(Long id) {
        Optional<Voiture> optionalVoiture = voitureRepository.findById(id);
        return optionalVoiture.map(VoitureMapper::toDto);
    }

    // Méthode pour sauvegarder une voiture et retourner le DTO
    public VoitureDTO save(VoitureDTO voitureDTO) {
        Voiture voiture = VoitureMapper.toEntity(voitureDTO);
        Voiture savedVoiture = voitureRepository.save(voiture);
        return VoitureMapper.toDto(savedVoiture);
    }

    // Méthode pour supprimer une voiture par ID
    public void deleteById(Long id) {
        voitureRepository.deleteById(id);
    }
}

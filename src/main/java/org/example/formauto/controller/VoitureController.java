package org.example.formauto.controller;

import org.example.formauto.DTO.VoitureDTO;
import org.example.formauto.entities.Voiture;
import org.example.formauto.services.VoitureService;
import org.example.formauto.utils.VoitureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;
    @Autowired
    private  VoitureMapper voitureMapper;


    // Récupérer toutes les voitures
    @GetMapping
    public List<VoitureDTO> getAllVoitures() {
        return voitureService.findAll(); // Appel direct à findAll qui retourne déjà des DTO
    }

    // Récupérer une voiture par ID
    @GetMapping("/{id}")
    public ResponseEntity<VoitureDTO> getVoitureById(@PathVariable Long id) {
        Optional<VoitureDTO> optionalVoiture = voitureService.findById(id);
        return optionalVoiture.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Créer une nouvelle voiture
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createVoiture(@ModelAttribute VoitureDTO voitureDTO,@RequestParam(value = "images", required = false) List<MultipartFile> images) {

        // Ajouter les images reçues dans la demande au DTO
        voitureDTO.setImages(images);

        voitureService.save(voitureDTO);

        // Convertir le DTO en entité Voiture
        Voiture voiture = voitureMapper.toEntity(voitureDTO);


        return ResponseEntity.status(HttpStatus.CREATED).body(voiture);
    }

    // Mettre à jour une voiture existante
    @PutMapping("/{id}")
    public ResponseEntity<VoitureDTO> updateVoiture(@PathVariable Long id, @RequestBody VoitureDTO voitureDTO) {
        Optional<VoitureDTO> optionalVoiture = voitureService.findById(id);
        if (optionalVoiture.isPresent()) {
            // Mettre à jour les champs nécessaires
            voitureDTO.setId(id); // Assurez-vous que l'ID est bien défini
            VoitureDTO updatedVoiture = voitureService.save(voitureDTO);
            return ResponseEntity.ok(updatedVoiture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer une voiture par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long id) {
        if (voitureService.findById(id).isPresent()) {
            voitureService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{voitureId}/addImage")
    public ResponseEntity<?> addImageToCar(@PathVariable Long voitureId,@RequestParam("image") MultipartFile file) {
        try {
            Voiture voiture = voitureService.addImage(voitureId, file);
            return ResponseEntity.status(HttpStatus.OK).body("Image added successfully to car with ID: " + voitureId);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image: " + e.getMessage());
        }
    }
}

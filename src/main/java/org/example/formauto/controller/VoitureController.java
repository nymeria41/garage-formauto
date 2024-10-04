package org.example.formauto.controller;

import org.example.formauto.DTO.VoitureDTO;
import org.example.formauto.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

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
    @PostMapping
    public ResponseEntity<VoitureDTO> createVoiture(@RequestBody VoitureDTO voitureDTO) {
        VoitureDTO savedVoiture = voitureService.save(voitureDTO);
        return ResponseEntity.ok(savedVoiture); // Utilise directement le DTO sauvegardé
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
}

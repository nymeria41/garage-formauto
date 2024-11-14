package org.example.formauto.utils;

import org.example.formauto.entities.Image;
import org.example.formauto.entities.Voiture;
import org.example.formauto.DTO.VoitureDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VoitureMapper {

    public static VoitureDTO toDto(Voiture voiture) {
        return new VoitureDTO(
                voiture.getId(),
                voiture.getMarque(),
                voiture.getModele(),
                voiture.getAnnee(),
                voiture.getPrix(),
                voiture.getDescription(),
                voiture.getCarburant(),
                voiture.getType(),
                voiture.getVitesse(),
                voiture.getCylindre(),
                voiture.getReservoir(),
                voiture.getBoite()
        );
    }

    public static Voiture toEntity(VoitureDTO voitureDTO) {
        Voiture voiture = new Voiture();
        voiture.setId(voitureDTO.getId());
        voiture.setMarque(voitureDTO.getMarque());
        voiture.setModele(voitureDTO.getModele());
        voiture.setAnnee(voitureDTO.getAnnee());
        voiture.setPrix(voitureDTO.getPrix());
        voiture.setDescription(voitureDTO.getDescription());
        voiture.setCarburant(voitureDTO.getCarburant());
        voiture.setType(voitureDTO.getType());
        voiture.setVitesse(voitureDTO.getVitesse());
        voiture.setCylindre(voitureDTO.getCylindre());
        voiture.setReservoir(voitureDTO.getReservoir());
        voiture.setBoite(voitureDTO.getBoite());
        if (voitureDTO.getImages() != null && !voitureDTO.getImages().isEmpty()) {
            List<Image> images = voitureDTO.getImages().stream()
                    .map(file -> {
                        try {
                            return Image.builder()
                                    .name(file.getOriginalFilename())
                                    .type(file.getContentType())
                                    .imageData(ImageUtils.compressImage(file.getBytes()))
                                    .build();
                        } catch (IOException e) {
                            throw new RuntimeException("Error while processing image: " + file.getOriginalFilename(), e);
                        }
                    })
                    .collect(Collectors.toList());

            voiture.setImages(images);
        }
        return voiture;
    }
}

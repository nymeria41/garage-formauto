package org.example.formauto.utils;

import org.example.formauto.entities.Voiture;
import org.example.formauto.DTO.VoitureDTO;

public class VoitureMapper {

    public static VoitureDTO toDto(Voiture voiture) {
        return new VoitureDTO(
                voiture.getId(),
                voiture.getMarque(),
                voiture.getModele(),
                voiture.getAnnee(),
                voiture.getPrix()
        );
    }

    public static Voiture toEntity(VoitureDTO voitureDTO) {
        Voiture voiture = new Voiture();
        voiture.setId(voitureDTO.getId());
        voiture.setMarque(voitureDTO.getMarque());
        voiture.setModele(voitureDTO.getModele());
        voiture.setAnnee(voitureDTO.getAnnee());
        voiture.setPrix(voitureDTO.getPrix());
        return voiture;
    }
}

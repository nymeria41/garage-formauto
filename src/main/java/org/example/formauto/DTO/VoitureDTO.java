package org.example.formauto.DTO;

import lombok.Getter;
import lombok.Setter;

public class VoitureDTO {

    // Getters et Setters
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String marque;
    @Setter
    @Getter
    private String modele;
    @Setter
    @Getter
    private int annee;
    @Setter
    @Getter
    private double prix;

    // Constructeur par défaut
    public VoitureDTO() {
    }

    // Constructeur avec paramètres
    public VoitureDTO(Long id, String marque, String modele, int annee, double prix) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.prix = prix;
    }

}


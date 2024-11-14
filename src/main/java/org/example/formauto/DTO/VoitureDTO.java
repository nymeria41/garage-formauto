package org.example.formauto.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Getter
@Setter
public class VoitureDTO {


    private Long id;
    private String marque;
    private String modele;
    private int annee;
    private double prix;
    private String description;
    private String carburant;
    private String type;
    private int vitesse;
    private int cylindre;
    private int reservoir;
    private String boite;
    private List<MultipartFile> images;

    // Constructeur par défaut
    public VoitureDTO() {
    }

    // Constructeur avec paramètres
    public VoitureDTO(Long id, String marque, String modele, int annee, double prix, String description, String carburant, String type, int vitesse, int cylindre, int reservoir, String boite, List<MultipartFile> images) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.prix = prix;
        this.description = description;
        this.carburant = carburant;
        this.type = type;
        this.vitesse = vitesse;
        this.cylindre = cylindre;
        this.reservoir = reservoir;
        this.boite = boite;
        this.images = images;
    }

    public VoitureDTO(Long id, String marque, String modele, int annee, double prix, String description, String carburant, String type, int vitesse, int cylindre, int reservoir, String boite) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.prix = prix;
        this.description = description;
        this.carburant = carburant;
        this.type = type;
        this.vitesse = vitesse;
        this.cylindre = cylindre;
        this.reservoir = reservoir;
        this.boite = boite;
    }
}


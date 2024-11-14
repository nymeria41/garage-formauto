package org.example.formauto.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "voiture")
public class Voiture {

    // Getters et setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;



}

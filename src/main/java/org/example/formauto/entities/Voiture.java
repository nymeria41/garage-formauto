package org.example.formauto.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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

}

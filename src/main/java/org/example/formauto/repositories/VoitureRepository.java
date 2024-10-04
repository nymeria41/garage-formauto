package org.example.formauto.repositories;

import org.example.formauto.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    // Méthodes de requête personnalisées si nécessaire
}

package com.example.authentification.services;


import com.example.authentification.models.Reclamation;
import com.example.authentification.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService {
    @Autowired
    private ReclamationRepository reclamationRepository;

    // Ajouter une réclamation
    public Reclamation ajouterReclamation(Reclamation reclamation) {
        reclamation.setDateCreation(LocalDateTime.now());
        reclamation.setStatut("En attente");
        return reclamationRepository.save(reclamation);
    }

    // Récupérer toutes les réclamations
    public List<Reclamation> recupererToutesReclamations() {
        return reclamationRepository.findAll();
    }

    // Récupérer une réclamation par ID
    public Optional<Reclamation> recupererReclamationParId(Long id) {
        return reclamationRepository.findById(id);
    }

    // Mettre à jour une réclamation
    public Reclamation mettreAJourReclamation(Long id, Reclamation detailsReclamation) {
        return reclamationRepository.findById(id).map(reclamation -> {
            reclamation.setTitre(detailsReclamation.getTitre());
            reclamation.setDescription(detailsReclamation.getDescription());
            reclamation.setStatut(detailsReclamation.getStatut());
            return reclamationRepository.save(reclamation);
        }).orElseThrow(() -> new RuntimeException("Réclamation non trouvée"));
    }

    // Supprimer une réclamation
    public void supprimerReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }
}


package com.example.authentification.controller;


import com.example.authentification.models.Reclamation;
import com.example.authentification.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth/reclamations")
public class ReclamationController {
    @Autowired
    private ReclamationService reclamationService;

    // Ajouter une réclamation
    @PostMapping
    public Reclamation ajouterReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.ajouterReclamation(reclamation);
    }

    // Récupérer toutes les réclamations
    @GetMapping
    public List<Reclamation> recupererToutesReclamations() {
        return reclamationService.recupererToutesReclamations();
    }

    // Récupérer une réclamation par ID
    @GetMapping("/{id}")
    public Optional<Reclamation> recupererReclamationParId(@PathVariable Long id) {
        return reclamationService.recupererReclamationParId(id);
    }

    // Mettre à jour une réclamation
    @PutMapping("/{id}")
    public Reclamation mettreAJourReclamation(@PathVariable Long id, @RequestBody Reclamation reclamation) {
        return reclamationService.mettreAJourReclamation(id, reclamation);
    }

    // Supprimer une réclamation
    @DeleteMapping("/{id}")
    public void supprimerReclamation(@PathVariable Long id) {
        reclamationService.supprimerReclamation(id);
    }
}

package com.example.authentification.controller;


import com.example.authentification.models.Projet;
import com.example.authentification.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/projets")
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    // Ajouter un nouveau projet
    @PostMapping
    public ResponseEntity<Projet> ajouterProjet(@RequestBody Projet projet) {
        Projet nouveauProjet = projetService.ajouterProjet(projet);
        return ResponseEntity.ok(nouveauProjet);
    }

    // Récupérer tous les projets
    @GetMapping
    public ResponseEntity<List<Projet>> getTousLesProjets() {
        List<Projet> projets = projetService.getTousLesProjets();
        return ResponseEntity.ok(projets);
    }

    // Récupérer un projet par ID
    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetParId(@PathVariable Long id) {
        return projetService.getProjetParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Mettre à jour un projet
    @PutMapping("/{id}")
    public ResponseEntity<Projet> mettreAJourProjet(@PathVariable Long id, @RequestBody Projet projetDetails) {
        try {
            Projet projetMisAJour = projetService.mettreAJourProjet(id, projetDetails);
            return ResponseEntity.ok(projetMisAJour);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un projet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProjet(@PathVariable Long id) {
        try {
            projetService.supprimerProjet(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}


package com.example.authentification.services;


import com.example.authentification.models.Projet;
import com.example.authentification.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    // Ajouter un projet
    public Projet ajouterProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    // Récupérer tous les projets
    public List<Projet> getTousLesProjets() {
        return projetRepository.findAll();
    }

    // Récupérer un projet par ID
    public Optional<Projet> getProjetParId(Long id) {
        return projetRepository.findById(id);
    }

    // Mettre à jour un projet
    public Projet mettreAJourProjet(Long id, Projet projetDetails) {
        return projetRepository.findById(id).map(projet -> {
            projet.setNom(projetDetails.getNom());
            projet.setDescription(projetDetails.getDescription());
            projet.setBudget(projetDetails.getBudget());
            projet.setDateDebut(projetDetails.getDateDebut());
            projet.setDateFin(projetDetails.getDateFin());
            return projetRepository.save(projet);
        }).orElseThrow(() -> new RuntimeException("Projet non trouvé avec l'ID : " + id));
    }

    // Supprimer un projet
    public void supprimerProjet(Long id) {
        projetRepository.deleteById(id);
    }
}

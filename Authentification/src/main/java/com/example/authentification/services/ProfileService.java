package com.example.authentification.services;

import com.example.authentification.models.Profile;
import com.example.authentification.models.Projet;
import com.example.authentification.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.authentification.repository.ProjetRepository;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private ProfileRepository profileRepository;

    // Injecter le repository des projets pour récupérer les projets depuis la base de données

    // Méthode pour vérifier si un profil peut postuler à un projet basé sur les compétences
    public boolean peutPostuler(Profile profile, Projet projet) {
        // Vérification si les compétences du profil contiennent les compétences demandées par le projet
        String[] skillsProfil = profile.getSkills() != null ? profile.getSkills().split(",") : new String[0];
        String[] skillsProjet = projet.getSkills() != null ? projet.getSkills().split(",") : new String[0];

        // Si les compétences demandées sont trouvées dans les compétences du profil, on peut postuler
        for (String skill : skillsProjet) {
            boolean found = false;
            for (String profilSkill : skillsProfil) {
                if (profilSkill.trim().equalsIgnoreCase(skill.trim())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false; // Si une compétence du projet n'est pas présente dans le profil, on ne peut pas postuler
            }
        }

        return true; // Si toutes les compétences du projet sont trouvées dans le profil
    }

    // Exemple de méthode pour récupérer les projets disponibles pour un profil
    public List<Projet> getProjetsDisponibles(Profile profile) {
        // Récupérer tous les projets depuis la base de données
        List<Projet> projets = projetRepository.findAll();

        // Filtrer les projets en fonction des compétences du profil
        return projets.stream()
                .filter(projet -> peutPostuler(profile, projet)) // Filtrer les projets où le profil peut postuler
                .toList();
    }

    // Autres méthodes nécessaires pour gérer les profils...

    public List<Profile> getAllProfiles() {
        // Code pour récupérer tous les profils
        return profileRepository.findAll();
    }

    public Profile getProfile(Long id) {
        // Code pour récupérer un profil par ID
        return profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profil non trouvé"));
    }

    public Profile saveProfile(Profile profile) {
        // Code pour enregistrer un profil
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile profile) {
        // Code pour mettre à jour un profil
        Profile existingProfile = profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profil non trouvé"));
        existingProfile.setFirstName(profile.getFirstName());
        existingProfile.setLastName(profile.getLastName());
        existingProfile.setEmail(profile.getEmail());
        existingProfile.setPhoneNumber(profile.getPhoneNumber());
        existingProfile.setAddress(profile.getAddress());
        existingProfile.setSkills(profile.getSkills());
        existingProfile.setGender(profile.getGender());
        return profileRepository.save(existingProfile);
    }

    public void deleteProfile(Long id) {
        // Code pour supprimer un profil
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profil non trouvé"));
        profileRepository.delete(profile);
    }
}

package com.example.authentification.controller;

import com.example.authentification.models.Profile;
import com.example.authentification.models.Projet;
import com.example.authentification.repository.ProfileRepository;
import com.example.authentification.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService; // Service injecté

    @Autowired
    private ProfileRepository profileRepository;

    // GET: /profiles
    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    // GET: /profiles/{id}
    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable Long id) {
        return profileService.getProfile(id);
    }

    // POST: /profiles
    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.saveProfile(profile);
    }

    // PUT: /profiles/{id}
    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return profileService.updateProfile(id, profile);
    }

    // DELETE: /profiles/{id}
    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
    }

    // GET: /projets (Récupérer les projets disponibles pour un profil)
    // GET: /projets (Récupérer les projets disponibles pour un profil)
    @GetMapping("/projets")
    public ResponseEntity<?> getProjets(@RequestParam Long profilId) {
        // Récupérer le profil par ID
        Profile profile = profileRepository.findById(profilId)
                .orElseThrow(() -> new RuntimeException("Profil non trouvé"));

        // Récupérer la liste des projets disponibles pour ce profil
        List<Projet> projetsDisponibles = profileService.getProjetsDisponibles(profile);

        // Si aucun projet n'est compatible avec le profil, retourner une erreur
        if (projetsDisponibles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun projet compatible trouvé pour ce profil.");
        }

        // Retourner les projets compatibles avec le profil
        return ResponseEntity.ok(projetsDisponibles);
    }
}

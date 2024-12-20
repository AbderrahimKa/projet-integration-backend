package com.example.authentification.controller;


import com.example.authentification.models.Contrat;
import com.example.authentification.services.ContratService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/contrats")
public class ContratController {

    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @PostMapping
    public ResponseEntity<Contrat> creerContrat(@RequestBody Contrat contrat) {
        return ResponseEntity.ok(contratService.creerContrat(contrat));
    }

    @GetMapping
    public ResponseEntity<List<Contrat>> obtenirTousLesContrats() {
        return ResponseEntity.ok(contratService.obtenirTousLesContrats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> obtenirContratParId(@PathVariable Long id) {
        return contratService.obtenirContratParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> mettreAJourContrat(@PathVariable Long id, @RequestBody Contrat contrat) {
        return ResponseEntity.ok(contratService.mettreAJourContrat(id, contrat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerContrat(@PathVariable Long id) {
        contratService.supprimerContrat(id);
        return ResponseEntity.noContent().build();
    }
}

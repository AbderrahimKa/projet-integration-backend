package com.example.authentification.controller;

import com.example.authentification.models.Disponibilite;
import com.example.authentification.services.DisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth/disponibilites")
public class DisponibiliteController {

    @Autowired
    private DisponibiliteService disponibiliteService;

    @PostMapping
    public ResponseEntity<Disponibilite> createDisponibilite(@RequestBody Disponibilite disponibilite) {
        Disponibilite createdDisponibilite = disponibiliteService.createDisponibilite(disponibilite);
        return ResponseEntity.ok(createdDisponibilite);
    }

    @GetMapping("/freelance/{freelanceId}")
    public ResponseEntity<List<Disponibilite>> getDisponibilitesByFreelanceId(@PathVariable Long freelanceId) {
        return ResponseEntity.ok(disponibiliteService.getDisponibilitesByFreelanceId(freelanceId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disponibilite> getDisponibiliteById(@PathVariable Long id) {
        Optional<Disponibilite> disponibilite = disponibiliteService.getDisponibiliteById(id);
        return disponibilite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disponibilite> updateDisponibilite(@PathVariable Long id, @RequestBody Disponibilite disponibilite) {
        return ResponseEntity.ok(disponibiliteService.updateDisponibilite(id, disponibilite));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisponibilite(@PathVariable Long id) {
        disponibiliteService.deleteDisponibilite(id);
        return ResponseEntity.noContent().build();
    }
}

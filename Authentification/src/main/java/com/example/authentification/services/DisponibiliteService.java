package com.example.authentification.services;

import com.example.authentification.models.Disponibilite;
import com.example.authentification.repository.DisponibiliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisponibiliteService {

    @Autowired
    private DisponibiliteRepository disponibiliteRepository;

    public Disponibilite createDisponibilite(Disponibilite disponibilite) {
        return disponibiliteRepository.save(disponibilite);
    }

    public List<Disponibilite> getDisponibilitesByFreelanceId(Long freelanceId) {
        return disponibiliteRepository.findByFreelanceId(freelanceId);
    }

    public Optional<Disponibilite> getDisponibiliteById(Long id) {
        return disponibiliteRepository.findById(id);
    }

    public Disponibilite updateDisponibilite(Long id, Disponibilite disponibilite) {
        if (disponibiliteRepository.existsById(id)) {
            disponibilite.setId(id);
            return disponibiliteRepository.save(disponibilite);
        }
        throw new RuntimeException("Disponibilité non trouvée");
    }

    public void deleteDisponibilite(Long id) {
        disponibiliteRepository.deleteById(id);
    }
}

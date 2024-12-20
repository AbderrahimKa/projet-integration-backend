package com.example.authentification.services;


import com.example.authentification.models.Contrat;
import com.example.authentification.repository.ContratRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService {

    private final ContratRepository contratRepository;

    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    public Contrat creerContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    public List<Contrat> obtenirTousLesContrats() {
        return contratRepository.findAll();
    }

    public Optional<Contrat> obtenirContratParId(Long id) {
        return contratRepository.findById(id);
    }

    public Contrat mettreAJourContrat(Long id, Contrat detailsContrat) {
        return contratRepository.findById(id).map(contrat -> {
            contrat.setFreelance(detailsContrat.getFreelance());
            contrat.setClient(detailsContrat.getClient());
            contrat.setDateEcheance(detailsContrat.getDateEcheance());
            contrat.setStatut(detailsContrat.getStatut());
            contrat.setSignatureElectronique(detailsContrat.getSignatureElectronique());
            return contratRepository.save(contrat);
        }).orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
    }

    public void supprimerContrat(Long id) {
        contratRepository.deleteById(id);
    }
}

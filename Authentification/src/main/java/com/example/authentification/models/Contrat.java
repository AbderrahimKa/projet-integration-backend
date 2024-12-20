package com.example.authentification.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String freelance;

    @Column(nullable = false)
    private String client;

    @Column(nullable = false)
    private LocalDateTime dateCreation;

    @Column(nullable = false)
    private LocalDateTime dateEcheance;

    @Column(nullable = false)
    private String statut; // "En cours", "Terminé", "Annulé"

    @Lob
    private String signatureElectronique;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFreelance() {
        return freelance;
    }

    public void setFreelance(String freelance) {
        this.freelance = freelance;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDateTime dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getSignatureElectronique() {
        return signatureElectronique;
    }

    public void setSignatureElectronique(String signatureElectronique) {
        this.signatureElectronique = signatureElectronique;
    }
}

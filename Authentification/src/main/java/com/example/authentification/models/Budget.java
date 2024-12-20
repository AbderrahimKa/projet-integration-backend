package com.example.authentification.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double prevision; // Budget prévu
    private Double depensesReelles; // Dépenses réelles
    private Double fondsAttribues; // Fonds attribués

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrevision() {
        return prevision;
    }

    public void setPrevision(Double prevision) {
        this.prevision = prevision;
    }

    public Double getDepensesReelles() {
        return depensesReelles;
    }

    public void setDepensesReelles(Double depensesReelles) {
        this.depensesReelles = depensesReelles;
    }

    public Double getFondsAttribues() {
        return fondsAttribues;
    }

    public void setFondsAttribues(Double fondsAttribues) {
        this.fondsAttribues = fondsAttribues;
    }
}


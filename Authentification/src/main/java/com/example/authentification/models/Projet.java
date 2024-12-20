package com.example.authentification.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "projet")
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false)
    private String description;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "date_debut")
    private String dateDebut;

    @Column(name = "date_fin")
    private String dateFin;

    @Column(name = "skills", nullable = true) // Compétences demandées pour le projet
    private String skills; // Les compétences requises pour le projet

    // Constructeur par défaut
    public Projet() {}

    // Constructeur avec paramètres
    public Projet(String nom, String description, Double budget, String dateDebut, String dateFin, String skills) {
        this.nom = nom;
        this.description = description;
        this.budget = budget;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.skills = skills;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    public String getDateDebut() { return dateDebut; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }

    public String getDateFin() { return dateFin; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", budget=" + budget +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}

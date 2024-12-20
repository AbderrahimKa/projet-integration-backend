package com.example.authentification.controller;

import com.example.authentification.models.Budget;
import com.example.authentification.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // Créer ou mettre à jour un budget
    @PostMapping
    public Budget creerOuMettreAJourBudget(@RequestBody Budget budget) {
        return budgetService.creerOuMettreAJourBudget(budget);
    }

    // Obtenir tous les budgets
    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    // Obtenir un budget par son ID
    @GetMapping("/{id}")
    public Optional<Budget> getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id);
    }

    // Calculer l'écart entre prévision et dépenses réelles
    @GetMapping("/ecart/{id}")
    public Double calculerEcart(@PathVariable Long id) {
        return budgetService.calculerEcart(id);
    }

    // Attribuer des fonds à un budget
    @PutMapping("/attribuer-fonds/{id}")
    public Budget attribuerFonds(@PathVariable Long id, @RequestParam Double montant) {
        return budgetService.attribuerFonds(id, montant);
    }
}

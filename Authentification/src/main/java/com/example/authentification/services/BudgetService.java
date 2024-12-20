package com.example.authentification.services;

import com.example.authentification.models.Budget;
import com.example.authentification.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    // Créer ou mettre à jour un budget
    public Budget creerOuMettreAJourBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    // Récupérer tous les budgets
    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    // Récupérer un budget par son ID
    public Optional<Budget> getBudgetById(Long id) {
        return budgetRepository.findById(id);
    }

    // Calculer l'écart entre la prévision et les dépenses réelles
    public Double calculerEcart(Long id) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        if (budgetOptional.isPresent()) {
            Budget budget = budgetOptional.get();
            return budget.getPrevision() - budget.getDepensesReelles();
        }
        return null;
    }

    // Mettre à jour les fonds attribués à un budget
    public Budget attribuerFonds(Long id, Double montant) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        if (budgetOptional.isPresent()) {
            Budget budget = budgetOptional.get();
            budget.setFondsAttribues(montant);
            return budgetRepository.save(budget);
        }
        return null;
    }
}

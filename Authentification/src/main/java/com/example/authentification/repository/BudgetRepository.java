package com.example.authentification.repository;

import com.example.authentification.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire.
    // Par exemple, pour obtenir un budget par son prévision ou ses dépenses réelles:
    // List<Budget> findByPrevision(Double prevision);
    // List<Budget> findByDepensesReelles(Double depensesReelles);
}


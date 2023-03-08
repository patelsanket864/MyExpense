package com.home.ExpenseCalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.home.ExpenseCalculator.model.ExpenseEntry;

@Repository
public interface ExpenseRepo extends JpaRepository<ExpenseEntry, Integer> {

	@Query("SELECT SUM(amount) FROM ExpenseEntry")
	double calculateExpense();

}

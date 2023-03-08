package com.home.ExpenseCalculator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.ExpenseCalculator.model.ExpenseEntry;
import com.home.ExpenseCalculator.repository.ExpenseRepo;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ExpenseController {

	Logger logger = LoggerFactory.getLogger(ExpenseController.class);
	
	@Autowired
	ExpenseRepo er;

	@Autowired
	ExpenseEntry expense;

	@GetMapping("/getAll")
	public List<ExpenseEntry> getExpenses() {
		logger.info("Controller--getExpenses()--started");
		return er.findAll();
	}

	@PostMapping("/addExpense")
	public String addExpense(@RequestBody ExpenseEntry ee) {
		logger.info("Controller--addExpense()--started");
		ExpenseEntry newExpense = new ExpenseEntry(ee.getExpenseName(), ee.getAmount(), ee.getPaymentType(),
				ee.getExpenseTime(), ee.getExpenseDate(), ee.getExpenseCount(), ee.getExpenseQuantity(),ee.getAmount()*ee.getExpenseCount());
		er.save(newExpense);
		logger.info("Controller--addExpense()--ended");
		return "added";
	}

	@DeleteMapping("/deleteAllExpense")
	public String deleteExpense() {
		logger.info("Controller--addExpense()--started");
		er.deleteAll();
		logger.info("Controller--deleteExpense()--ended");
		return "All Expense Deleted";
	}

	@GetMapping("/calculateExpense")
	public double calculateExpense() {
		logger.info("Controller--addExpense()--started");
		double total = er.calculateExpense();
		logger.info("Controller--calculateExpense()--ended");
		return total;
	}
}

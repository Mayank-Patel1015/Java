package com.mayank.SaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mayank.SaveTravels.models.Expense;
import com.mayank.SaveTravels.repositories.ExpenseRepo;

import jakarta.validation.Valid;

@Service
public class ExpenseService {
	
	private final ExpenseRepo expenseRepo;
	
	public ExpenseService(ExpenseRepo expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public Expense addExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public Expense getExpense(Long id) {
		Optional<Expense> potentialExpense = expenseRepo.findById(id);
		return potentialExpense.isPresent() ? potentialExpense.get() : null;
	}
	
	public List<Expense> getAll() {
		return (List<Expense>) expenseRepo.findAll();
	}

	public Expense create(Expense expense) {
		return expenseRepo.save(expense);
	}

	public Object getOne(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		return expense.isPresent() ? expense.get() : null;
	}

	public Expense update(@Valid Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public void delete(Long id) {
		expenseRepo.deleteById(id);
	}
}

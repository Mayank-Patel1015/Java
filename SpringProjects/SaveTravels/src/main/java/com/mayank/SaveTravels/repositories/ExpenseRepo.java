package com.mayank.SaveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mayank.SaveTravels.models.Expense;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense,Long>{
	List<Expense> findAll();
}

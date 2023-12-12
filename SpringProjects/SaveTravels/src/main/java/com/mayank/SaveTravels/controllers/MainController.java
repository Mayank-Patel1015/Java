package com.mayank.SaveTravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mayank.SaveTravels.models.Expense;
import com.mayank.SaveTravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("")
public class MainController {
	
	@Autowired
	private ExpenseService expenseServ;
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("allExpenses", expenseServ.getAll());
		return "expenses.jsp";
	}
	
	@PostMapping("/process")
	public String processCreateDonation(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allExpenses", expenseServ.getAll());
			return "expenses.jsp";
		}
		expenseServ.create(expense);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseServ.getOne(id));
		return "edit.jsp";
	}
	
	@PatchMapping("/processUpdate/{id}")
	public String processEditDonation(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		expenseServ.update(expense);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		expenseServ.delete(id);
		return "redirect:/expenses";
	}
	
	
	
	
}




// Mr. Robert Santos said its okay to submit this for login and Registration.

package com.mayank.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mayank.bookclub.services.BookService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private BookService bookServ;

	public HomeController() {}
	
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("allBooks", bookServ.getAll());
		return "main/dashboard.jsp";
	}
	

}

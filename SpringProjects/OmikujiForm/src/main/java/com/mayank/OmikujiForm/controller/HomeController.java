package com.mayank.OmikujiForm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class HomeController {
	@GetMapping("/")
	public String displayForm(HttpSession session) {
		return "form.jsp";
	}
	
	@PostMapping("/process")
	public String processForm(@RequestParam("number") int number, @RequestParam("city") String city,  @RequestParam("name") String name, @RequestParam("hobby") String hobby,  @RequestParam("animal") String animal,  @RequestParam("comment") String comment, HttpSession session,  RedirectAttributes redirectAttributes ) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("animal", animal);
		session.setAttribute("comment", comment);
		return "redirect:/display";
	}
	
	@GetMapping("/display")
	public String displayOmikuji() {
		return "showForm.jsp";
	}
}

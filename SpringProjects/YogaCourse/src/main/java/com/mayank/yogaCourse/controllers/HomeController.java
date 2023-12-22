package com.mayank.yogaCourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mayank.yogaCourse.services.CourseService;
import com.mayank.yogaCourse.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private CourseService courseServ;
	
	@Autowired
	private UserService userServ;

	public HomeController() {
	}

	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.getUser((Long)session.getAttribute("user_id")));
		model.addAttribute("allCourses", courseServ.getAll());
		return "main/dashboard.jsp";
	}

}

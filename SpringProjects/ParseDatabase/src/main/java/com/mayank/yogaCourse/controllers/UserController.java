package com.mayank.yogaCourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mayank.yogaCourse.models.LoginUser;
import com.mayank.yogaCourse.models.User;
import com.mayank.yogaCourse.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	private UserService userServ;

	public UserController() {
	}

	@GetMapping("/")
	public String loginRegPage(@ModelAttribute("user") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
		// model.addAttribute("user", new User());
		// model.addAttribute("loginUser", new LoginUser());
		return "user/loginReg.jsp";
	}

	@PostMapping("/process/register")
	public String processRegForm(@Valid @ModelAttribute("user") User user, BindingResult results, Model model,
			HttpSession session) {
		if (!user.getPassword().equals(user.getConfirm())) {
			results.rejectValue("password", "Match", "Confirm Password must match Password!");
		}
		if (userServ.getUser(user.getEmail()) != null) {
			results.rejectValue("email", "Unique", "Email already in use!");
		}
		if (results.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "user/loginReg.jsp";
		}
		User newUser = userServ.register(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
	}

	@PostMapping("/process/login")
	public String processLoginFrom(@Valid @ModelAttribute("loginUser") LoginUser user, BindingResult results,
			Model model, HttpSession session) {
		User logginUser = userServ.login(user, results);
		if (results.hasErrors()) {
			model.addAttribute("user", new User());
			return "user/loginReg.jsp";
		}
		session.setAttribute("user_id", logginUser.getId());
		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}

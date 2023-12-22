package com.mayank.yogaCourse.controllers;

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

import com.mayank.yogaCourse.models.Course;
import com.mayank.yogaCourse.models.Student;
import com.mayank.yogaCourse.services.CourseService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseServ;

	public CourseController() {
	}

	@GetMapping("/create")
	public String createCourse(@ModelAttribute("course") Course course, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/home";
		}
		return "course/create.jsp";
	}

	@PostMapping("/process/create")
	public String processCreateCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/home";
		}
		if (result.hasErrors()) {
			return "course/create.jsp";
		}

		courseServ.create(course);
		return "redirect:/home";
	}

	@GetMapping("/edit/{id}")
	public String editCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
//		System.out.println(session.getAttribute("user_id").equals(courseServ.getOne(id).getInstructor().getId()));
//			|| session.getAttribute("user_id") != courseServ.getOne(id).getInstructor().getId()
		if (session.getAttribute("user_id") == null || !session.getAttribute("user_id").equals(courseServ.getOne(id).getInstructor().getId())) {
			return "redirect:/home";
		}
		model.addAttribute("course", courseServ.getOne(id));
		return "course/edit.jsp";
	}

	@PatchMapping("/process/edit/{id}")
	public String processEditCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/home";
		}
		if (result.hasErrors()) {
			return "course/edit.jsp";
		}
		courseServ.update(course);
		return "redirect:/home";
	}

	@GetMapping("/display/{id}")
	public String showOneCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/home";
		}
		model.addAttribute("course", courseServ.getOne(id));
		return "course/showOne.jsp";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCourse(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/home";
		}
		courseServ.delete(id);
		return "redirect:/home";
	}
	
	@GetMapping("/create/student")
	public String createStudent(@ModelAttribute("student") Student student, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/home";
		}
		return "student_genre/createStudent.jsp";
	}
	
	
	@PostMapping("/process/create/student")
	public String CreateStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/home";
		}
		if(result.hasErrors()) {
			System.out.println(result.getFieldErrors());
			return "student_genre/createStudent.jsp";
		}
		courseServ.createStudentWithCourse(student);
		return "redirect:/students/genres/create/student";
	}
}

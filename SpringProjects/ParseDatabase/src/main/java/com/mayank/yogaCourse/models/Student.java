package com.mayank.yogaCourse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // generates an auto incrementing 
	private Long id;
	@NotEmpty(message = "Student Name is required!") // validation for strings
	private String name;
	@NotEmpty(message = "Email is required!")
	private String email;
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "students_courses", 
            joinColumns = @JoinColumn(name = "student_id"), 
            inverseJoinColumns = @JoinColumn(name = "course_id")
        )
    private List<Course> courses;
	
	@Transient
    private String formCourse;

	
	public Student() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFormCourse() {
		return formCourse;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setFormCourse(String formCourse) {
		this.formCourse = formCourse;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
}

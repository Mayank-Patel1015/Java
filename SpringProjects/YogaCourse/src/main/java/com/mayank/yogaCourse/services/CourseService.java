package com.mayank.yogaCourse.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.yogaCourse.models.Course;
import com.mayank.yogaCourse.models.Student;
import com.mayank.yogaCourse.repositories.CourseRepository;
import com.mayank.yogaCourse.repositories.StudentRepository;

@Service
public class CourseService {

	 @Autowired
	 private StudentRepository studentRepo;

	private final CourseRepository courseRepo;

	public CourseService(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}

	public Course getOne(Long id) {
		Optional<Course> course = courseRepo.findById(id);
		return course.isPresent() ? course.get() : null;
	}

	public List<Course> getAll() {
		return (List<Course>) courseRepo.findAll();
	}

	public Course create(Course course) {
		return courseRepo.save(course);
	}

	public Course update(Course course) {
		return courseRepo.save(course);
	}

	public void delete(Long id) {
		courseRepo.deleteById(id);
	}
	
	public Course getOne(String name) {
		Optional<Course> genre = courseRepo.findByCourseName(name);
		return genre.isPresent() ? genre.get() : null;
	}

	
	public Course createCourseIfNotInDatabase(String courseName) {
		if(this.getOne(courseName) == null) {
			Course newCourse = new Course();
			newCourse.setCourseName(courseName);
			return courseRepo.save(newCourse);
		}
		return this.getOne(courseName);
	}
	
	public Student createStudentWithCourse(Student student) {
		String[] coursesFromForm = student.getFormCourse().split(",");
		ArrayList<Course> coursesToBeAdded = new ArrayList<Course>();
		for(String course: coursesFromForm)
		{
			coursesToBeAdded.add(this.createCourseIfNotInDatabase(course));
		}
		student.setCourses(coursesToBeAdded);
		return studentRepo.save(student);
	}
	
}

package com.mayank.yogaCourse.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mayank.yogaCourse.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	List<Course> findAll();
	
	Optional<Course> findByCourseName(String courseName);
}

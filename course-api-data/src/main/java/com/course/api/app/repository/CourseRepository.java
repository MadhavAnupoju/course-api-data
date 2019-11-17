package com.course.api.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.course.api.app.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}

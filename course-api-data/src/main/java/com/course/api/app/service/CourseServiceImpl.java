package com.course.api.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.api.app.model.Course;
import com.course.api.app.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;
	@Override
	public Course getCourseDetails(String courseName) throws Exception {
		try {
			//return getAllCourses().stream().filter(c->c.getName().equals(courseName)).findFirst().get();
			return courseRepository.findByName(courseName);
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public Course getCourseDetails(long id) throws Exception {
		try {
			return courseRepository.findById(id).get();
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	public List<Course> getAllCourses() throws Exception {

		try {
			List<Course> courses = new ArrayList<Course>();
			courseRepository.findAll().forEach(courses::add);
			return courses;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Course> addCourse(Course course) throws Exception {
		try {
			courseRepository.save(course);
			return getAllCourses();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Course updateById(Course course,long id) throws Exception {
		try {
			course.setId(id);
			Course crse=getCourseDetails(id);
			BeanUtils.copyProperties(course, crse);
			courseRepository.save(course);
			return crse;
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public List<Course> deleteCourseById(long id) throws Exception {
		try {
			courseRepository.deleteById(id);
			return getAllCourses();
		} catch (Exception e) {
			throw e;
		}
	}

}

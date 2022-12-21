package com.platformcommon.service;

import java.util.List;

import com.platformcommon.DTO.CourseDTO;
import com.platformcommon.DTO.CourseStudents;
import com.platformcommon.DTO.StudentCourse;
import com.platformcommon.exception.CourseException;
import com.platformcommon.exception.StudentException;

public interface CourseService {

	public CourseDTO addCourse(CourseDTO courseDTO) throws CourseException;
	
	public StudentCourse assignCourseToStudent(Integer studentId,Integer courseId) throws CourseException, StudentException;
	
	public CourseStudents getStudentsFromCourse(Integer courseId) throws CourseException;
	
	public List<CourseDTO> getCoursesByTopic(String topicName) throws CourseException;
	
	public CourseDTO removeCourse(Integer courseId) throws CourseException;
	
	
}
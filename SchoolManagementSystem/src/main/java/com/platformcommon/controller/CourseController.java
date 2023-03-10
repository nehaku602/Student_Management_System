package com.platformcommon.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platformcommon.DTO.CourseDTO;
import com.platformcommon.DTO.CourseStudents;
import com.platformcommon.DTO.StudentCourse;
import com.platformcommon.exception.CourseException;
import com.platformcommon.exception.StudentException;
import com.platformcommon.service.CourseService;

import jakarta.validation.Valid;

@RestController
public class CourseController {

	
	@Autowired(required = false)
	private CourseService courseService;
	
//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/courses/")
	public ResponseEntity<CourseDTO> addCourseHandler(@Valid @RequestBody CourseDTO courseDTO) throws CourseException {
		
		CourseDTO savedCourse = courseService.addCourse(courseDTO);
		
		return new ResponseEntity<CourseDTO>(savedCourse,HttpStatus.CREATED) ;
	}
	 
//	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/courses/assgign")
	public ResponseEntity<StudentCourse> assginStudentToCourseHandler(@RequestParam("studentId") Integer sttudentId,
																	@RequestParam("courseId") Integer courseId) throws CourseException, StudentException {
		
		StudentCourse assignedCourse =  courseService.assignCourseToStudent(sttudentId, courseId) ;
		
		return new ResponseEntity<StudentCourse>(assignedCourse,HttpStatus.OK) ;
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/courses/")
	public ResponseEntity<CourseStudents> getStudentsFromCorseHandler(@RequestParam Integer courseId) throws CourseException {
		
		CourseStudents courseStudents =  courseService.getStudentsFromCourse(courseId);
		
		return new ResponseEntity<CourseStudents>(courseStudents,HttpStatus.OK) ;
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/courses/")
	public ResponseEntity<CourseDTO> removeCourseHandler(@RequestParam Integer courseId) throws CourseException {
		
		CourseDTO removedCourse =  courseService.removeCourse(courseId);
		
		return new ResponseEntity<CourseDTO>(removedCourse,HttpStatus.OK) ;
	}
	
	@GetMapping("/courses/topic")
	public ResponseEntity<List<CourseDTO>> getCoursesByTopic(@RequestParam("topicName") String topicName) throws CourseException {
		
		List<CourseDTO> courses =  courseService.getCoursesByTopic(topicName);
		
		return new ResponseEntity<List<CourseDTO>>(courses,HttpStatus.OK);
	}
	
}






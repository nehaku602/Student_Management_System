package com.platformcommon.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platformcommon.DTO.StudentAddressDTO;
import com.platformcommon.DTO.StudentCourse;
import com.platformcommon.DTO.StudentDTO;
import com.platformcommon.DTO.StudentUpdateDTO;
import com.platformcommon.exception.CourseException;
import com.platformcommon.exception.StudentException;
import com.platformcommon.exception.UserException;
import com.platformcommon.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/students/")
	public ResponseEntity<StudentDTO> registerStudentHandler(@Valid @RequestBody StudentDTO studentDTO)
			throws StudentException, UserException {

		StudentDTO registredStudent = studentService.registerStudent(studentDTO);

		return new ResponseEntity<StudentDTO>(registredStudent, HttpStatus.CREATED);
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/students/")
	public ResponseEntity<List<StudentDTO>> getStudentsByNameHandler(@RequestParam("name") String name)
			throws StudentException {

		List<StudentDTO> studentsList = studentService.getStudentByName(name);

		return new ResponseEntity<List<StudentDTO>>(studentsList, HttpStatus.OK);
	}

	@PatchMapping("/students/update/")
	public ResponseEntity<StudentDTO> updateEmailAndMobileNumberHandler(@RequestBody StudentUpdateDTO studentUpdateDTO)
			throws StudentException {

		StudentDTO studentDTO = studentService.updateEmailAndMobile(studentUpdateDTO);

		return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
	}

	@PatchMapping("/students/update/address")
	public ResponseEntity<StudentDTO> updateAddressHandler(@Valid @RequestBody StudentAddressDTO studentAddressDTO)
			throws StudentException {

		StudentDTO studentDTO = studentService.updateStudentAddress(studentAddressDTO);

		return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
	}
	
	@PutMapping("/students/add/address")
	public ResponseEntity<StudentDTO> addAddressHandler(@Valid @RequestBody StudentAddressDTO studentAddressDTO)
			throws StudentException {

		StudentDTO studentDTO = studentService.addNewAddress(studentAddressDTO);
		
		return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
	}

	@DeleteMapping("/students/courses")
	public ResponseEntity<StudentCourse> leaveCourseHandler(@RequestParam("studentId") Integer studentId,
															@RequestParam("dob,dd-MM-yyyy") String dateOfBirth, 
															@RequestParam("courseId") Integer courseId)
															throws StudentException, CourseException {

		StudentCourse studentCourse = studentService.leaveCourse(studentId, dateOfBirth, courseId);

		return new ResponseEntity<StudentCourse>(studentCourse, HttpStatus.OK);
	}

	@GetMapping("/students/courses")
	public ResponseEntity<StudentCourse> getStudentCoursesHandler(@RequestParam("studentId") Integer studentId,
																@RequestParam("dob,dd-MM-yyyy") String dateOfBirth) throws StudentException
																{

		StudentCourse studentCourse = studentService.getStudentCourses(studentId, dateOfBirth) ;

		return new ResponseEntity<StudentCourse>(studentCourse, HttpStatus.OK);
	}
}

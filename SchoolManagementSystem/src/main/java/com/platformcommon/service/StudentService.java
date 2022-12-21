package com.platformcommon.service;

import java.util.List;

import com.platformcommon.DTO.StudentAddressDTO;
import com.platformcommon.DTO.StudentCourse;
import com.platformcommon.DTO.StudentDTO;
import com.platformcommon.DTO.StudentUpdateDTO;
import com.platformcommon.entity.Course;
import com.platformcommon.entity.Student;
import com.platformcommon.exception.CourseException;
import com.platformcommon.exception.StudentException;
import com.platformcommon.exception.UserException;

public interface StudentService {

	public StudentDTO registerStudent(StudentDTO studentDTO) throws StudentException, UserException;
	
	public Student getStudentById(Integer studentId) throws StudentException ;
	
	public List<Course> getAllCoursesAdminPurpose(Integer studentId) throws StudentException ;
	
	public List<StudentDTO> getStudentByName(String name) throws StudentException;
	
	public StudentDTO updateEmailAndMobile(StudentUpdateDTO dto) throws StudentException;
	
	public StudentDTO updateStudentAddress(StudentAddressDTO addressDTO) throws StudentException;
	
	public StudentCourse getStudentCourses(Integer studentId,String dateOfBirth) throws StudentException;
	
	public StudentCourse leaveCourse(Integer studentId,String dateOfBirth,Integer courseId) throws StudentException, CourseException;
	
	public StudentCourse coursesToStudentCourse(List<Course> courses,Student student) ;
	
	public StudentDTO addNewAddress(StudentAddressDTO addressDTO) throws StudentException;
}

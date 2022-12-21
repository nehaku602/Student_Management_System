package com.platformcommon.DTO;

import java.util.ArrayList;
import java.util.List;

public class StudentCourse {

	private Integer StudentId;
	private String name;
	
	private List<CourseDTO> courses = new ArrayList<>();


	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentCourse(Integer studentId, String name, List<CourseDTO> courses) {
		super();
		StudentId = studentId;
		this.name = name;
		this.courses = courses;
	}

	public Integer getStudentId() {
		return StudentId;
	}

	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}
	
	
	
}

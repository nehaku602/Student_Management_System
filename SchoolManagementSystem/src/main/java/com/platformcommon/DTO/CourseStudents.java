package com.platformcommon.DTO;

import java.util.ArrayList;
import java.util.List;

public class CourseStudents {

	private Integer courseId;
	private String courseName;
	private String description;
	private String courseType;
	private String duration;
	private String topics;
	
	List<StudentDTO> studentList = new ArrayList<>();

	
	public CourseStudents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseStudents(Integer courseId, String courseName, String description, String courseType, String duration,
			String topics, List<StudentDTO> studentList) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.duration = duration;
		this.topics = topics;
		this.studentList = studentList;
	}



	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public List<StudentDTO> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentDTO> studentList) {
		this.studentList = studentList;
	}
	
	
}

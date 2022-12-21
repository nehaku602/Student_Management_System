package com.platformcommon.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	
	private String courseName;
	
	private String description;
	
	private String courseType;
	
	private String duration;
	
	private String topics;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Student> students = new ArrayList<>();

	
	 
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Integer courseId, String courseName, String description, String courseType, String duration,
			String topics, List<Student> students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.duration = duration;
		this.topics = topics;
		this.students = students;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", courseType=" + courseType + ", duration=" + duration + ", topics=" + topics + ", students="
				+ students + "]";
	}
	
	
	
}

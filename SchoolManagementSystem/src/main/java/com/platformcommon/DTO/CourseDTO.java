package com.platformcommon.DTO;

public class CourseDTO {

    private Integer courseId;
	
	private String courseName;
	
	private String description;
	
	private String courseType;
	
	private String duration;
	
	private String topics;

	
	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CourseDTO(Integer courseId, String courseName, String description, String courseType, String duration,
			String topics) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.duration = duration;
		this.topics = topics;
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
	
	
	
}

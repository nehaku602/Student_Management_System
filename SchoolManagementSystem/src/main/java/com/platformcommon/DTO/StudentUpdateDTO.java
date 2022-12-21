package com.platformcommon.DTO;

import java.time.LocalDate;



public class StudentUpdateDTO {

	private Integer studentId;
	private LocalDate dob;
	

	private String newEmail;

	
	private String newMobileNumber;

	
	public StudentUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentUpdateDTO(Integer studentId, LocalDate dob, String newEmail, String newMobileNumber) {
		super();
		this.studentId = studentId;
		this.dob = dob;
		this.newEmail = newEmail;
		this.newMobileNumber = newMobileNumber;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getNewMobileNumber() {
		return newMobileNumber;
	}

	public void setNewMobileNumber(String newMobileNumber) {
		this.newMobileNumber = newMobileNumber;
	}

	
	
	
	
}

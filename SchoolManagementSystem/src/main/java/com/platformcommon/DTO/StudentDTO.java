package com.platformcommon.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.platformcommon.entity.Address;

public class StudentDTO {

    private Integer studentId;
	
	private String name;
	private String email;
	private String mobileNumber;
	private String fatherName;
	private String motherName;
	private LocalDate dob;
	private String gender;
	private String unique_studentCode;
	
	
	private List<Address> address = new ArrayList<>();

    
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentDTO(Integer studentId, String name, String email, String mobileNumber, String fatherName,
			String motherName, LocalDate dob, String gender, String unique_studentCode, List<Address> address) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.dob = dob;
		this.gender = gender;
		this.unique_studentCode = unique_studentCode;
		this.address = address;
	}


	public Integer getStudentId() {
		return studentId;
	}


	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getUnique_studentCode() {
		return unique_studentCode;
	}


	public void setUnique_studentCode(String unique_studentCode) {
		this.unique_studentCode = unique_studentCode;
	}


	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
}


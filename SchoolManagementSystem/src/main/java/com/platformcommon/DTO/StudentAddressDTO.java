package com.platformcommon.DTO;

import java.time.LocalDate;

import com.platformcommon.entity.Address;

public class StudentAddressDTO {

	private Integer studentId;
	private LocalDate dob;
	private Address address;
	
	
	public StudentAddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public StudentAddressDTO(Integer studentId, LocalDate dob, Address address) {
		super();
		this.studentId = studentId;
		this.dob = dob;
		this.address = address;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}

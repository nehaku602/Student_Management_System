package com.platformcommon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	private String name;
	private String mobileNumber;
	private String password;
	private String role;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String mobileNumber, String password, String role) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
	}

	public User(String name, String mobileNumber, String password) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}

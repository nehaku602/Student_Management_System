package com.platformcommon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.platformcommon.DTO.UserDTO;
import com.platformcommon.exception.AdminException;
import com.platformcommon.exception.UserException;
import com.platformcommon.service.UserService;

import jakarta.validation.Valid;

@RestController
public class AdminController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/admin/register")
	public ResponseEntity<UserDTO> registerAdminHandler(@Valid @RequestBody UserDTO userDTO	) throws AdminException, UserException {
		
		UserDTO registeredUser =  userService.registerUser(userDTO) ;
		
		return new ResponseEntity<UserDTO>(registeredUser,HttpStatus.CREATED) ;
	}
}

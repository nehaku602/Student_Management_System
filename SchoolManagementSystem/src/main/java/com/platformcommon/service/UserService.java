package com.platformcommon.service;

import com.platformcommon.DTO.UserDTO;
import com.platformcommon.exception.UserException;

public interface UserService {

	public UserDTO registerUser(UserDTO userDTO) throws UserException;
	
	public UserDTO registerStudentAsUser(UserDTO userDTO) throws UserException;
	
}

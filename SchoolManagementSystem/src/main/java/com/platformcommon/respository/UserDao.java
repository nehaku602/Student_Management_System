package com.platformcommon.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformcommon.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

	public User findByMobileNumber(String mobileNumber);
}

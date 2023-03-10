package com.platformcommon.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.platformcommon.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{

	@Query("from Student s where s.name LIKE %:name% ") 
	public List<Student> getStudentsByName(String name) ;
	
}

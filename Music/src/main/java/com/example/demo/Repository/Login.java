package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.User;


public interface Login extends JpaRepository<User, Integer>{
	
		@Query("SELECT password FROM User e WHERE e.username = :username")
		public String findPassword(@Param(value = "username") String username);
	
}


	
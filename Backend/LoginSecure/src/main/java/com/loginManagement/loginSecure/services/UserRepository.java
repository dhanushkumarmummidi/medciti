package com.loginManagement.loginSecure.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginManagement.loginSecure.loginModel.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
	 Users findByEmail(String email);
	 Users findByUsername(String id);
	
	
}
  
package com.loginManagement.loginSecure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loginManagement.loginSecure.loginModel.UserPrincipal;
import com.loginManagement.loginSecure.loginModel.Users;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         System.out.println("IN login   "+email);
		Users user = repo.findByEmail(email);
		
		if(user==null) {
			user = repo.findByUsername(email);
			if(user == null)
				throw new  UsernameNotFoundException("User not found");
		}
		
		return new UserPrincipal(user);
	}

}
 
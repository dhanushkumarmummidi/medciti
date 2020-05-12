package com.loginManagement.loginSecure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loginManagement.loginSecure.authentication.models.AuthenticationRequest;
import com.loginManagement.loginSecure.authentication.models.AuthenticationResponse;
import com.loginManagement.loginSecure.filters.JwtRequestFilter;
import com.loginManagement.loginSecure.loginModel.Users;
import com.loginManagement.loginSecure.services.MyUserDetailsService;
import com.loginManagement.loginSecure.services.UserRepository;
import com.loginManagement.loginSecure.util.JwtUtil;

@CrossOrigin
@Controller
public class HomeController 
{
	@Autowired
	private JwtRequestFilter jwtfilter;
	@Autowired
	private UserRepository repo;
	private UserDetails userDetails;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
    
	@RequestMapping(value="/authenticate",method= RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
	authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(authenticationRequest.getemail(), authenticationRequest.getPassword())
								);
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password",e);
		}
    userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getemail());
    System.out.println(userDetails);
     final String 	jwt = jwtTokenUtil.generateToken(userDetails);

     return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/user",method=RequestMethod.POST)
    @ResponseBody
    public Users getDashboard()
    {
    	System.out.println(jwtfilter.getName());
    //	Users users= repo.findByUsername(jwtfilter.getName());
    	System.out.println(repo.findByUsername(jwtfilter.getName()));
    	return repo.findByUsername(jwtfilter.getName());
    
    }
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

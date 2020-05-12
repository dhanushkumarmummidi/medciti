package com.loginManagement.loginSecure.authentication.models;

public class AuthenticationRequest 
{
	private String email;
	private String password;
	public AuthenticationRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public AuthenticationRequest() {
		
	}
	
	
	
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

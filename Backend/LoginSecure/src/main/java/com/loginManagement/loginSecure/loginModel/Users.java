package com.loginManagement.loginSecure.loginModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class Users 
{
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String username;
	@Column(name="designation")
	private String designation;
	@Column(name="password")
	private String password;
	@Column(name="qualification")
	private String qualification;
	@Column(name="locationid")
	private int locationId;
	@Column(name="access")
	private int access;
	@Column(name="email")
	private String email;
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", designation=" + designation + ", password=" + password
				+ ", qualification=" + qualification + ", locationId=" + locationId + ", access=" + access + ", email="
				+ email + "]";
	}
	
}

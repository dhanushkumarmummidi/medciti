package com.technocrats.order.beans;

import javax.persistence.Column;

public class User {
	private int id;
	private String name;
	private String designation;
	private String password;
	private String qualification;
	private int locationId;
	private int access;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", designation=" + designation + ", password=" + password
				+ ", qualification=" + qualification + ", locationId=" + locationId + ", access=" + access + "]";
	}
	
}

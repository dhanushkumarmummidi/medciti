package com.technocrats.order.beans;

public class Location {
	int id;
	String brandname;
	String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", brandname=" + brandname + ", address=" + address + "]";
	}
	
	
}

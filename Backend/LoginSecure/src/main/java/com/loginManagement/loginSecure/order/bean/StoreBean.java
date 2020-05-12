package com.loginManagement.loginSecure.order.bean;

import javax.persistence.Column;

public class StoreBean {
	int id;
	String brandName;
	String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StoreBean [id=" + id + ", brandName=" + brandName + ", address=" + address + "]";
	}
	
}

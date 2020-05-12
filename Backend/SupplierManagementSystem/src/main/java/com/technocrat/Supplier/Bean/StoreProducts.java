package com.technocrat.Supplier.Bean;

import javax.persistence.Column;

public class StoreProducts {
	private int id;
	private String product;
	private int location;
	private int availablequantity;
	private int requiredquantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getAvailablequantity() {
		return availablequantity;
	}
	public void setAvailablequantity(int availablequantity) {
		this.availablequantity = availablequantity;
	}
	public int getRequiredquantity() {
		return requiredquantity;
	}
	public void setRequiredquantity(int requiredquantity) {
		this.requiredquantity = requiredquantity;
	}
	@Override
	public String toString() {
		return "StoreProducts [id=" + id + ", product=" + product + ", location=" + location + ", availablequantity="
				+ availablequantity + ", requiredquantity=" + requiredquantity + "]";
	}
	
}

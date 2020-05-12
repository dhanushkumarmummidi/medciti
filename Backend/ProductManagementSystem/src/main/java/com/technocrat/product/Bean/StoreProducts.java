package com.technocrat.product.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storeproducts")
public class StoreProducts {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "product")
	private String product;
	@Column(name = "location")
	private int location;
	@Column(name = "availablequantity")
	private int availablequantity;
	@Column(name = "requiredquantity")
	private int requiredquantity;
	public StoreProducts() {}
		
	public StoreProducts(int id, String product, int location, int availablequantity, int requiredquantity) {
		super();
		this.id = id;
		this.product = product;
		this.location = location;
		this.availablequantity = availablequantity;
		this.requiredquantity = requiredquantity;
	}

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

	public String toString() {
		return "Product [id=" + id + ", product=" + product + ", location=" + location + ",availablequantity ="
				+ availablequantity + ", requiredquantity=" + requiredquantity + "]";
	}
}

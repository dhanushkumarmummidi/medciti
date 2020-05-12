package com.loginManagement.loginSecure.ProductManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private int price;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name = "description")
	private String description;
	@Column(name = "chemicalformula")
	private String chemicalformula;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getChemicalformula() {
		return chemicalformula;
	}
	public void setChemicalformula(String chemicalformula) {
		this.chemicalformula = chemicalformula;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", manufacturer=" + manufacturer + ", description="
				+ description + ", chemicalformula=" + chemicalformula + "]";
	}

}

package com.technocrat.Supplier.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplierorderproducts")

public class SupplierOrderProducts {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "product")
	private String product;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "supplierorderid")
	private int supplierorderid;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSupplierorderid() {
		return supplierorderid;
	}

	public void setSupplierorderid(int supplierorderid) {
		this.supplierorderid = supplierorderid;
	}
	
	public String toString() {
		return "SupplierOrderProducts [id=" + id + ", product=" + product + ", quantity=" + quantity + ", supplierorderid="
				+ supplierorderid + "]";
	}
}

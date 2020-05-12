package com.technocrat.Supplier.Bean;

import java.util.List;

public class ResponseInventryOrder {
	Supplier supplier;
	List<SupplierOrderProducts> orderProducts;
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public List<SupplierOrderProducts> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<SupplierOrderProducts> orderProducts) {
		this.orderProducts = orderProducts;
	}
	@Override
	public String toString() {
		return "ResponseInventryOrder [supplier=" + supplier + ", orderProducts=" + orderProducts + "]";
	}
	
}

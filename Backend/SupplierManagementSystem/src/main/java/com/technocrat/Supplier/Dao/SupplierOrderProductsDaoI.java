package com.technocrat.Supplier.Dao;

import java.util.List;

import com.technocrat.Supplier.Bean.SupplierOrderProducts;

public interface SupplierOrderProductsDaoI {
	public List<SupplierOrderProducts> get();

	public SupplierOrderProducts getSupplierOrderById(int id);

	void addSupplierOrderProducts(SupplierOrderProducts supplierorderproducts);

	void updateSupplierOrderProducts(SupplierOrderProducts supplierorderproducts);

	boolean deleteSupplierOrderProducts(int id);

	List<SupplierOrderProducts> get(int pagestart, int pageEnd);

	List<SupplierOrderProducts> getSupplierOrderByIdSupplierOrder(int id);
}

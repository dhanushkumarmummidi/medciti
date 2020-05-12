package com.technocrat.Supplier.Service;

import java.util.List;

import com.technocrat.Supplier.Bean.SupplierOrderProducts;

public interface SupplierOrderProductsServiceI {
	
	public List<SupplierOrderProducts> get();

	public SupplierOrderProducts getSupplierOrderProductsById(int id);

	void addSupplierOrderProducts(SupplierOrderProducts supplierorderproducts);

	void updateSupplierOrderProducts(SupplierOrderProducts supplierorderproducts);

	boolean deleteSupplierOrderProducts(int id);

	List<SupplierOrderProducts> get(int pagestart, int pageEnd);

	public List<SupplierOrderProducts> getSupplierOrderProductsBySupplierOrder(int orderId);

}

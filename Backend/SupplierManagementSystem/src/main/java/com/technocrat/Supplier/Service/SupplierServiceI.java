package com.technocrat.Supplier.Service;

import java.util.List;

import com.technocrat.Supplier.Bean.ResponseInventryOrder;
import com.technocrat.Supplier.Bean.StoreProducts;
import com.technocrat.Supplier.Bean.Supplier;
import com.technocrat.Supplier.Bean.SupplierOrderProducts;


public interface SupplierServiceI {

	public List<Supplier> get();

	public Supplier getSupplierOrderById(int id);

	Integer addSupplierOrder(Supplier supplier);

	void updateSupplierOrder(Supplier supplier);

	boolean deleteSupplierOrder(int id);

	List<Supplier> get(int pagestart, int pageEnd);
	
	public Supplier getByLocation(int locationId);

	ResponseInventryOrder getAndCreateOrder(int locationId);
}

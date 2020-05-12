package com.technocrat.Supplier.Dao;

import java.util.List;

import com.technocrat.Supplier.Bean.Supplier;

public interface SupplierDaoI {

	public List<Supplier> get();

	public Supplier getSupplierOrderById(int id);

	Integer addSupplierOrder(Supplier supplier);

	void updateSupplierOrder(Supplier supplier);

	boolean deleteSupplierOrder(int id);

	List<Supplier> get(int pagestart, int pageEnd);

	Supplier getSupplierOrderByLocation(int id);

	
}

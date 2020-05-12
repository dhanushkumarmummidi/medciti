package com.technocrat.Supplier.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technocrat.Supplier.Bean.SupplierOrderProducts;
import com.technocrat.Supplier.Dao.SupplierOrderProductsDaoI;

@Service
public class SupplierOrderProductsService implements SupplierOrderProductsServiceI {

	@Autowired
	SupplierOrderProductsDaoI supplierOrderProductsDao;

	@Transactional
	public List<SupplierOrderProducts> get() {
		// TODO Auto-generated method stub
		return supplierOrderProductsDao.get();
		}

	@Transactional
	public SupplierOrderProducts getSupplierOrderProductsById(int id) {
		// TODO Auto-generated method stub
		return supplierOrderProductsDao.getSupplierOrderById(id);
	}

	@Transactional
	public List<SupplierOrderProducts> getSupplierOrderProductsBySupplierOrder(int id) {
		// TODO Auto-generated method stub
		return supplierOrderProductsDao.getSupplierOrderByIdSupplierOrder(id);
	}
	
	@Transactional
	public void addSupplierOrderProducts(SupplierOrderProducts supplierorderproducts) {
		// TODO Auto-generated method stub
		supplierOrderProductsDao.addSupplierOrderProducts(supplierorderproducts);
		
	}

	@Transactional
	public void updateSupplierOrderProducts(SupplierOrderProducts supplierorderproducts) {
		// TODO Auto-generated method stub
		supplierOrderProductsDao.updateSupplierOrderProducts(supplierorderproducts);
	}

	@Transactional
	public boolean deleteSupplierOrderProducts(int id) {
		// TODO Auto-generated method stub
		return supplierOrderProductsDao.deleteSupplierOrderProducts(id);
	}

	@Transactional
	public List<SupplierOrderProducts> get(int pagestart, int pageEnd) {
		// TODO Auto-generated method stub
		return supplierOrderProductsDao.get(pagestart, pageEnd);
	}

}

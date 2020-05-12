package com.technocrat.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technocrat.product.Bean.Product;
import com.technocrat.product.dao.ProductDao;
import com.technocrat.product.dao.ProductDaoI;

@Service
public class ProductService implements ProductServiceI {

	@Autowired
	ProductDaoI productDao;

	@Transactional
	@Override
	public List<Product> get() {
		return productDao.get();
	}
	

	public Product getProductByName(String name) {
		return productDao.getProductByName(name);
	}

	@Transactional
	@Override
	public void addProduct(Product product) throws  Exception {
		productDao.addProduct(product);
	}

	@Transactional
	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Transactional
	@Override
	public boolean deleteProduct(String name) {
		return productDao.deleteProduct(name);

	}

	
	@Override
	public List<Product> get(int pageStart, int pageEnd) {
		// TODO Auto-generated method stub
		return productDao.get(pageStart, pageEnd);
	}
	
	

}

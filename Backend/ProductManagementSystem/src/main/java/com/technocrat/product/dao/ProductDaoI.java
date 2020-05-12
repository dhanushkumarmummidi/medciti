package com.technocrat.product.dao;

import java.util.List;

import com.technocrat.product.Bean.Product;

public interface ProductDaoI {
	public List<Product> get();

	public Product getProductByName(String name);

	void addProduct(Product product);

	void updateProduct(Product product);

	boolean deleteProduct(String name);

	List<Product> get(int pageStart, int pageEnd);
}

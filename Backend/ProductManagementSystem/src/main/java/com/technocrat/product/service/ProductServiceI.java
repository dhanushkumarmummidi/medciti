package com.technocrat.product.service;

import java.util.List;

import com.technocrat.product.Bean.Product;

public interface ProductServiceI {

	public List<Product> get();

	public Product getProductByName(String name);

	void addProduct(Product product) throws Exception;

	void updateProduct(Product product);

	boolean deleteProduct(String name);

	List<Product> get(int pagestart, int pageEnd);

}

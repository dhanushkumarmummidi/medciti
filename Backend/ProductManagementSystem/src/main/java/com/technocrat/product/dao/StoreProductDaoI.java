package com.technocrat.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.technocrat.product.Bean.StoreProducts;
import com.technocrat.product.Bean.StoreProductsWithPrice;

public interface StoreProductDaoI {

	public List<StoreProducts> get();

	public StoreProducts getStoreProductById(int id);

	void addStoreProduct(StoreProducts storeproducts);

	void updateStoreProduct(StoreProducts storeproducts);

	boolean deleteStoreProduct(int id);

	List<StoreProducts> get(int pagestart, int pageEnd);

	StoreProducts getStoreProductByProductAndLocation(String product, int id);

	List<StoreProducts> searchStoreProductById(String key, int location);

	List<StoreProducts> get(int locationId);

	
}

package com.technocrat.product.service;

import java.util.List;

import com.technocrat.product.Bean.StoreProducts;
import com.technocrat.product.Bean.StoreProductsWithPrice;

public interface StoreProductServiceI {

	public List<StoreProducts> get();

	public StoreProducts getStoreProductById(int id);

	void addStoreProduct(StoreProducts storeproducts);

	void updateStoreProduct(StoreProducts storeproducts);

	boolean deleteStoreProduct(int id);

	List<StoreProducts> get(int pagestart, int pageEnd);

	List<StoreProductsWithPrice> searchStoreProducts(String key, int locationId);

	StoreProducts getStoreProduct(String key, int locationId);

	List<StoreProductsWithPrice> getStoreProductsByLocationId(int locationId);
	
}

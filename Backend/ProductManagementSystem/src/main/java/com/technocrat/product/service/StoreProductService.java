package com.technocrat.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.technocrat.product.Bean.StoreProducts;
import com.technocrat.product.Bean.StoreProductsWithPrice;
import com.technocrat.product.dao.ProductStoreDaoI;
import com.technocrat.product.dao.StoreProductDaoI;

@Service
public class StoreProductService implements StoreProductServiceI {

	@Autowired
	StoreProductDaoI storeproductDao;
	@Autowired
	ProductStoreDaoI productStoreDaoI;
	
	@Transactional
	public List<StoreProducts> get() {
		return storeproductDao.get();
	}
	@Override
	@Transactional
	public List<StoreProductsWithPrice> searchStoreProducts(String key,int locationId) {
		key="%"+key+"%";
		return productStoreDaoI.getStoreProductsWithPrice(locationId,key);
	}

	@Override
	@Transactional
	public StoreProducts getStoreProduct(String key,int locationId) {
		StoreProducts storeProduct=storeproductDao.getStoreProductByProductAndLocation(key, locationId);
		return storeProduct;
	}

	
	@Transactional
	public StoreProducts getStoreProductById(int id) {
		return storeproductDao.getStoreProductById(id);
	}

	@Transactional
	public void addStoreProduct(StoreProducts storeproducts) {
		StoreProducts storeProduct=storeproductDao.getStoreProductByProductAndLocation(storeproducts.getProduct(), storeproducts.getLocation());
		if(storeProduct==null) {
			storeproductDao.addStoreProduct(storeproducts);
		}
		else {
			updateStoreProduct(storeproducts);
		}
	}

	@Transactional
	public void updateStoreProduct(StoreProducts storeproducts) {
		storeproductDao.updateStoreProduct(storeproducts);
	}

	@Transactional
	public boolean deleteStoreProduct(int id) {
		return storeproductDao.deleteStoreProduct(id);

	}

	public List<StoreProducts> get(int pageStart, int pageEnd) {
		// TODO Auto-generated method stub
		return storeproductDao.get(pageStart, pageEnd);
	}
	@Override
	@Transactional
	public List<StoreProductsWithPrice> getStoreProductsByLocationId(int locationId) {
		return productStoreDaoI.getStoreProductsWithPrice(locationId);
	}
	
}

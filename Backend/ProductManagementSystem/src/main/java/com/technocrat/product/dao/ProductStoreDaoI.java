package com.technocrat.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.technocrat.product.Bean.StoreProducts;
import com.technocrat.product.Bean.StoreProductsWithPrice;

public interface ProductStoreDaoI extends CrudRepository<StoreProducts, String> {
	@Query(value = "SELECT new com.technocrat.product.Bean.StoreProductsWithPrice (sp.id as id,sp.product as product,sp.location as location,sp.availablequantity as availablequantity,sp.requiredquantity as requiredquantity,p.price as price) FROM StoreProducts sp , Product p where sp.product = p.name and sp.location=?1")
	public List<StoreProductsWithPrice> getStoreProductsWithPrice(int locationId) ;
	@Query(value = "SELECT new com.technocrat.product.Bean.StoreProductsWithPrice (sp.id as id,sp.product as product,sp.location as location,sp.availablequantity as availablequantity,sp.requiredquantity as requiredquantity,p.price as price) FROM StoreProducts sp , Product p where sp.product = p.name and sp.location=?1 and sp.product like ?2")
	public List<StoreProductsWithPrice> getStoreProductsWithPrice(int locationId,String key) ;
	
}

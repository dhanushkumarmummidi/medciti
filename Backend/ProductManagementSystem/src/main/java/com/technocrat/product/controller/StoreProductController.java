package com.technocrat.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.technocrat.product.Bean.StoreProducts;
import com.technocrat.product.Bean.StoreProductsWithPrice;
import com.technocrat.product.service.StoreProductServiceI;

@RestController
@RequestMapping("/storeproducts")
public class StoreProductController {

	@Autowired
	StoreProductServiceI storeproductService;

	@RequestMapping(value = "/getStoreProducts")
	public List<StoreProducts> getProducts() {

		return storeproductService.get();
	}
	@RequestMapping(value = "/searchStoreProducts")
	public List<StoreProductsWithPrice> searchStoreProducts(@RequestParam(value="key")String key,@RequestParam(value="locationId")String locationId) {

		return storeproductService.searchStoreProducts(key, Integer.parseInt(locationId));
	}

	@RequestMapping("/getUsersPagination")
	@ResponseBody
	public List<StoreProducts> getStoreProducts(@RequestParam(value = "pageStart") int pageStart,
			@RequestParam(value = "pageEnd") int pageEnd) {
		return storeproductService.get(pageStart, pageEnd);
	}

	@RequestMapping(value = "/getStoreProductbyId" ,method = RequestMethod.GET)
	@ResponseBody
	public StoreProducts getProductsbyId(@RequestParam(value = "id") int id) {

		return storeproductService.getStoreProductById(id);
	}

	@RequestMapping(value = "/getStoreProductbyNameAndLocation" ,method = RequestMethod.GET)
	@ResponseBody
	public StoreProducts getProductsbyId(@RequestParam(value = "Name") String name,@RequestParam(value="locationId") int locationId) {

		return storeproductService.getStoreProduct(name,locationId);
	}

	
	@RequestMapping(value = "/addNewStoreProduct", method = RequestMethod.POST)
	@ResponseBody
	public void addNewProduct(@RequestBody StoreProducts storeproducts) {
		storeproductService.addStoreProduct(storeproducts);
	}

	@RequestMapping(value = "/updateStoreProduct", method = RequestMethod.POST)
	@ResponseBody
	public void updateUser(@RequestBody StoreProducts storeproducts) {

		storeproductService.updateStoreProduct(storeproducts);
	}

	@RequestMapping(value = "/deleteStoreProduct", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteUser(@RequestParam(value = "id") int id) {
		return storeproductService.deleteStoreProduct(id);
	}
	@RequestMapping(value="/getStoreProductsByLocation")
	@ResponseBody
	public List<StoreProductsWithPrice> getStoreProductsByLocation(@RequestParam(value = "location") int location){
		return storeproductService.getStoreProductsByLocationId(location);
	}


}

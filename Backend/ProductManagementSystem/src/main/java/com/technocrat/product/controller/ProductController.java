package com.technocrat.product.controller;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.technocrat.product.Bean.DefaultResponse;
import com.technocrat.product.Bean.Product;
import com.technocrat.product.service.ProductServiceI;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductServiceI productService;

	
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping( value = "/endPoints", method = RequestMethod.GET )
	public Set<RequestMappingInfo> getEndPointsInView(  )
	{
	  return  requestMappingHandlerMapping.getHandlerMethods().keySet();
	}
	
	@RequestMapping(value = "/getProducts")
	public List<Product> getProducts() {

		return productService.get();
	}

	
	@RequestMapping("/getUsersPagination")
	@ResponseBody
	public List<Product> getProducts(@RequestParam(value="pageStart")int pageStart,@RequestParam(value="pageEnd")int pageEnd){
		return productService.get(pageStart,pageEnd);
	}
	
	@RequestMapping(value="/getProductbyname")
	@ResponseBody
	public Product getProductsbyname(@RequestParam(value="name")String name) {
		return productService.getProductByName(name);
	}
	

	@RequestMapping(value = "/addNewProduct", method = RequestMethod.POST)
	@ResponseBody
	public DefaultResponse<String> addNewProduct(@RequestBody Product product) {
		DefaultResponse<String> response = new DefaultResponse<String>();
		try {
			productService.addProduct(product);
			response.setDescription("Sucessfully add the product");
			response.setStatus("200");
			return response;
		} catch (Exception e) {
			response.setDescription("Sucessfully add the product");
			response.setStatus("200");
			e.printStackTrace();
			return response;
			
		}
	}



	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	@ResponseBody
	public void updateUser(@RequestBody Product product) {
		System.out.println(product);
		productService.updateProduct(product);
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteUser(@RequestParam(value="name") String name) {
		return productService.deleteProduct(name);
	}
}

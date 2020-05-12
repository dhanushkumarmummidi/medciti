package com.loginManagement.loginSecure.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loginManagement.loginSecure.ProductManagement.model.Product;

@CrossOrigin
@RestController("")
public class ProductManagementSystemController
{
	@Autowired 
	private RestTemplate restTemplate;
	HttpHeaders headers = new HttpHeaders();
	@RequestMapping(value="/api/products/getProducts",method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getProducts()
	{
		String url = "http://localhost:8083/products/getProducts";
	Product[] objects= restTemplate.getForObject(url, Product[].class);
		
		return Arrays.asList(objects);  
	}
	
	@RequestMapping(value="/api/products/getproductbyname/{name}",method = RequestMethod.GET)	
	@ResponseBody
	public Product getUser(@PathVariable("name") String name) 
	{
		String url = "http://localhost:8083/products/getProductbyname?name="+name;
		Product objects =restTemplate.getForObject(url, Product.class);
		System.out.println(objects);
		return objects;
	}
	@RequestMapping(value = "api/products/addProduct", method = RequestMethod.POST)
	@ResponseBody
	public String saveNewProduct(@RequestBody Product product)
	{
		String url = "http://localhost:8083/products/addNewProduct";
		System.out.println(product);
		return restTemplate.postForObject(url, product, String.class);
	}
	@RequestMapping(value = "api/products/updateProduct", method = RequestMethod.POST)
	@ResponseBody
	public void updateProduct(@RequestBody Product product) 
	{
		String url = "http://localhost:8083/products/updateProduct";
		System.out.println(product);
		HttpEntity<Product> requestUpdate = new HttpEntity<>(product, headers);
		restTemplate.exchange(url,HttpMethod.POST,requestUpdate,Product.class);
	}

	@RequestMapping(value = "api/products/deleteProduct/{name}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable("name") String name) {
		String url = "http://localhost:8083/products/deleteProduct";
		String entityUrl = url + "?name=" + name;
		restTemplate.delete(entityUrl);
	}
}

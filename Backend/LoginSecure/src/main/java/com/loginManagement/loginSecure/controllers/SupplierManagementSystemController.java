package com.loginManagement.loginSecure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loginManagement.loginSecure.filters.JwtRequestFilter;
import com.loginManagement.loginSecure.services.UserRepository;

import SupplierManagementSystem.models.Supplier;


@CrossOrigin
@RestController("")
public class SupplierManagementSystemController
{
	@Autowired
	private JwtRequestFilter jwtfilter;
	@Autowired 
	private RestTemplate restTemplate;
	@Autowired
	private UserRepository repo;
	HttpHeaders headers = new HttpHeaders();
	@RequestMapping(value="/api/supplier/getSupplierOrders",method = RequestMethod.GET)	
	@ResponseBody
	public String getSupplierOrders() 
	{
		System.out.println(jwtfilter.getName());
	    int location = repo.findByUsername(jwtfilter.getName()).getLocationId();
		String url = "http://localhost:8086/supplier/getSupplierOrders";
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}
	
	@RequestMapping(value="/api/supplier/getSupplierOrdersProductsByOrderId",method = RequestMethod.GET)	
	@ResponseBody
	public String getSupplierOrders(@RequestParam(value="orderId")int orderId) 
	{
		System.out.println(jwtfilter.getName());
	    int location = repo.findByUsername(jwtfilter.getName()).getLocationId();
		String url = "http://localhost:8086/supplierorderproducts/getSupplierOrderProductsByIdSupplierOrder?orderId="+orderId;
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}
	
	
	@RequestMapping(value="/api/supplier/getSupplierOrdersByLocation",method = RequestMethod.GET)	
	@ResponseBody
	public String getSupplierOrdersByLocation() 
	{
		System.out.println(jwtfilter.getName());
	    int location = repo.findByUsername(jwtfilter.getName()).getLocationId();
		String url = "http://localhost:8086/supplier/getSupplierOrderProductsByLocation?locationId="+location;
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}
	
	@RequestMapping(value="/api/supplier/getSupplierOrderById/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public String getSupplierOrderById(@PathVariable("id") int userId) 
	{
		String url = "http://localhost:8086/supplier/getSupplierOrders?id="+userId;
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}

	@RequestMapping(value="/api/supplier/addSupplierOrder",method = RequestMethod.POST)	
	@ResponseBody
	public void addSupplierOrder(@RequestBody Supplier supplier) 
	{
		String url = "http://localhost:8086/supplier/addSupplierOrder";
		 restTemplate.postForObject(url, supplier, Supplier.class);

		
	}
	
	@RequestMapping(value="/api/supplier/updateSupplierOrder",method = RequestMethod.POST)	
	@ResponseBody
	public String updateSupplierOrder(@RequestBody Supplier supplier) 
	{
		System.out.println("Update supplier order request "+supplier);
		String url = "http://localhost:8086/supplier/updateSupplierOrder";
		String response = restTemplate.postForObject(url, supplier, String.class);
		System.out.println("Response "+response);
		return response;
		
	}
	@RequestMapping(value="/api/supplier/deleteSupplierOrder/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public void deleteSupplierOrder(@PathVariable("id") int userId) 
	{
		String url = "http://localhost:8086/supplier/deleteSupplierOrder?id="+userId;
		restTemplate.delete(url);
		
	}

	@RequestMapping(value="/api/supplier/getAndCreateOrder")	
	@ResponseBody
	public String getAndCreateOrder(@RequestParam(value="locationId") String locationId) 
	{
		String url = "http://localhost:8086/supplier/createSupplierOrder?locationId="+locationId;
		return restTemplate.getForObject(url, String.class);
		
	}

}

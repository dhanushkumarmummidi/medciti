package com.loginManagement.loginSecure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loginManagement.loginSecure.order.bean.Sales;

@CrossOrigin
@RestController("")
public class SalesManagementController
{
	@Autowired 
	private RestTemplate restTemplate;
	HttpHeaders headers = new HttpHeaders();

	@RequestMapping(value="/api/sales/getInvoiceProducts/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public String getInvoiceProducts(@PathVariable("id") int userId) 
	{
		String url = "http://localhost:8085/sales/getInvoiceProducts?id="+userId;
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}
	@RequestMapping(value="/api/sales/createSale",method = RequestMethod.POST)	
	@ResponseBody
	public void createInvoice(@RequestBody Sales sale) 
	{
		String url = "http://localhost:8085/sales/createSale";
		 restTemplate.postForObject(url, sale, Sales.class);

		
	}
	
	
}

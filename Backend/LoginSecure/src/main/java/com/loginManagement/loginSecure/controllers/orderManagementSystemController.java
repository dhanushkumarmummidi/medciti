package com.loginManagement.loginSecure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loginManagement.loginSecure.UserManagement.model.User;
import com.loginManagement.loginSecure.filters.JwtRequestFilter;
import com.loginManagement.loginSecure.order.bean.Invoice;
import com.loginManagement.loginSecure.services.UserRepository;
@CrossOrigin
@RestController("")
public class orderManagementSystemController
{
	@Autowired 
	private RestTemplate restTemplate;
	HttpHeaders headers = new HttpHeaders();
	@Autowired
	private UserRepository repo;
	@Autowired
	private JwtRequestFilter jwtfilter;
	@RequestMapping(value="/api/invoice/getAllInvoices",method = RequestMethod.GET)	
	@ResponseBody
	public String getAllInvoices() 
	{
		String url = "http://localhost:8085/invoice/getAllInvoices";
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}
	
	
	@RequestMapping(value="/api/invoice/updateInvoice",method = RequestMethod.POST)	
	@ResponseBody
	public void updateInvoice(@RequestBody Invoice invoice) 
	{
		String url = "http://localhost:8085/invoice/updateInvoice";
		HttpEntity<Invoice> requestUpdate = new HttpEntity<>(invoice, headers);
		restTemplate.exchange(url,HttpMethod.POST,requestUpdate,Invoice.class);
		
	}
	
	
	
	@RequestMapping(value="/api/invoice/findInvoiceById/{id}",method = RequestMethod.GET)	
	@ResponseBody
	public String findInvoiceById(@PathVariable("id") int userId) 
	{
		String url = "http://localhost:8085/invoice/findInvoiceById?id="+userId;
		String objects =restTemplate.getForObject(url, String.class);
		System.out.println(objects);
		return objects;
	}
	
	
	
	@RequestMapping(value="/api/invoice/createInvoice",method = RequestMethod.POST)	
	@ResponseBody
	public String createInvoice(@RequestBody Invoice invoice) 
	{
		System.out.println("Insoidde invoice create");
		invoice.setUserid(repo.findByUsername(jwtfilter.getName()).getId());
		invoice.setLocation(repo.findByUsername(jwtfilter.getName()).getLocationId());
		System.out.println("Invoice input is "+invoice);
		String url = "http://localhost:8085/invoice/createInvoice";
		return restTemplate.postForObject(url, invoice, String.class);

		
	}
	
	@RequestMapping(value="/api/invoice/findSalesStatisticsWithData",method = RequestMethod.GET)	
	@ResponseBody
	public String createInvoice( ) 
	{
		int location = repo.findByUsername(jwtfilter.getName()).getLocationId();
		String url = "http://localhost:8085/invoice/findSalesStatisticsWithData?locationId="+location;
		return restTemplate.getForObject(url, String.class);
	}
	
}

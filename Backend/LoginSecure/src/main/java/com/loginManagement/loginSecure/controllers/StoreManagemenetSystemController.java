package com.loginManagement.loginSecure.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loginManagement.loginSecure.UserManagement.model.User;
import com.loginManagement.loginSecure.order.bean.StoreBean;

@CrossOrigin
@RestController("")
public class StoreManagemenetSystemController {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@RequestMapping("/addnewstore")
	@ResponseBody
	public ResponseEntity<String> addNewStore(@RequestBody StoreBean store) {
		
		String url = "http://localhost:8084/store/createStore";
		ResponseEntity<String> response =restTemplate.postForEntity(url, store, String.class);
		return response;
	}
	
	@RequestMapping("/getstore")
	@ResponseBody
	public String getStore(@RequestParam(value="id") int id) {
		
		String url = "http://localhost:8084/store/getStore?id="+id;
		String objects =restTemplate.getForObject(url, String.class);
		return objects;
	}
	
	@RequestMapping("/getallstore")
	@ResponseBody
	public String getAllStore() {
		
		String url = "http://localhost:8084/store/getAllStores";
		String objects =restTemplate.getForObject(url, String.class);
		return objects;
	}
	
	
}

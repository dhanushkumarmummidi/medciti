package com.storemanagementsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storemanagementsystem.beans.DefaultResponse;
import com.storemanagementsystem.beans.Store;
import com.storemanagementsystem.service.StoreService;

@RestController
@RequestMapping("/store")
public class StsController {
	@Autowired
	StoreService service;
	
	@RequestMapping("/createStore")
	public DefaultResponse<Store> createNewStore(@RequestBody Store store) {
		DefaultResponse<Store> response= new DefaultResponse<>();
		try {
			Store createdStore = service.createStore(store);
			response.setStatus("200");
			response.setData(createdStore);
		}
		catch(Exception e) {
			response.setStatus("400");
			response.setDescription(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("/updateStore")
	public DefaultResponse<Store> updateStore(@RequestBody Store store) {
		DefaultResponse<Store> response= new DefaultResponse<>();
		try {
			Store createdStore = service.updateStore(store);
			response.setStatus("200");
			response.setData(createdStore);
		}
		catch(Exception e) {
			response.setStatus("400");
			response.setDescription(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("/getStore")
	public DefaultResponse<Store> getStore(@RequestParam(value="storeId") int storeId) {
	
		DefaultResponse<Store> response= new DefaultResponse<>();
		try {
			Store createdStore = service.getStore(storeId);
			response.setStatus("200");
			response.setData(createdStore);
		}
		catch(Exception e) {
			response.setStatus("400");
			response.setDescription(e.getMessage());
		}
		return response;
		
		
	}
	
	@RequestMapping("/deleteStore")
	public DefaultResponse<String> deleteStore(@RequestParam(value="storeId") int storeId) {
		DefaultResponse<String> response= new DefaultResponse<>();
		try {
			service.deleteStore(storeId);
			response.setStatus("200");
			response.setData("Store deleted");
		}
		catch(Exception e) {
			response.setStatus("200");
			response.setDescription("Store deleted");
		}
		return response;
		
	}
	
	@RequestMapping("/getAllStores")
	public DefaultResponse<List<Store>> getAllStores() {
		
		DefaultResponse<List<Store>> response= new DefaultResponse<>();
		try {
			List<Store> stores = service.getAllStores();
			response.setStatus("200");
			response.setData(service.getAllStores());
		}
		catch(Exception e) {
			response.setStatus("200");
			response.setDescription("Store deleted");
		}
		return response;
		
		
	}
	
}

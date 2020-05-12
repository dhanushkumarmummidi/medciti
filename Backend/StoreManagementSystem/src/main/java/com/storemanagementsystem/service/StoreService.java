package com.storemanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storemanagementsystem.beans.Store;
import com.storemanagementsystem.dao.StoreDao;

@Service
public class StoreService {
	@Autowired
	StoreDao storeDao;
	@Transactional
	public Store createStore(Store store) throws Exception {
		return storeDao.save(store);
	}
	@Transactional
	public Store updateStore(Store store)throws Exception {
		return storeDao.save(store);
	}
	@Transactional
	public void deleteStore(int id)throws Exception {
		 storeDao.deleteById(id);
	}
	@Transactional
	public Store getStore(int id)throws Exception {
		return storeDao.findById(id);
	}
	@Transactional
	public List<Store> getAllStores()throws Exception {
		return storeDao.findAll();
	}
	
}

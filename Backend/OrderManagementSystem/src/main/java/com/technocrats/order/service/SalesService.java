package com.technocrats.order.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technocrats.order.beans.Sales;
import com.technocrats.order.dao.SalesDaoI;
@Service
public class SalesService {

	@Autowired
	SalesDaoI<Sales> salesDao;
	
	@Transactional
	public List<Sales> getAllSales() {
		return salesDao.findAll();
	}
	@Transactional
	public Sales getAllSales(int id) {
		return salesDao.findById(id);
	}
	@Transactional
	public int saveSales(Sales sale) {
		return salesDao.save(sale).getId();
	}
	
	
	
}

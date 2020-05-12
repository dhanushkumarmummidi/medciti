package com.technocrats.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.technocrats.order.beans.Sales;

public interface SalesDaoI<I> extends PagingAndSortingRepository<Sales,Integer>  {
	List<Sales> findAll();
	Sales findById(int id);
}

package com.storemanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.storemanagementsystem.beans.Store;

public interface StoreDao extends PagingAndSortingRepository<Store,Integer> {
	List<Store> findAll();
	Store saveAndFlush(Store invoice);
	Store findById(int id);
	void deleteById(int id);
}

package com.technocrat.product.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.technocrat.product.Bean.StoreProducts;
import com.technocrat.product.Bean.StoreProductsWithPrice;

@Repository
public class StoreProductDao implements StoreProductDaoI{

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<StoreProducts> get() {
		// TODO Auto-generated method stub
		Session currentsession = entityManager.unwrap(Session.class);
		List<StoreProducts> storeproduct = currentsession.createQuery("from StoreProducts", StoreProducts.class).getResultList();
		return storeproduct;
	}

	@Override
	public StoreProducts getStoreProductById(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from StoreProducts where id = :id ";
		StoreProducts storeproducts = (StoreProducts) currentSession.createQuery(hql).setParameter("id", id).getSingleResult();
		return storeproducts;
		
	}
	
	@Override
	public List<StoreProducts> searchStoreProductById(String key , int location) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from StoreProducts where location = :id and product like :key ";
		
		List<StoreProducts> storeproducts =  currentSession.createQuery(hql).setParameter("id", location).setParameter("key", key).getResultList();
		return storeproducts;
		
	}

	@Override
	public StoreProducts getStoreProductByProductAndLocation(String product,int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from StoreProducts where product = :product and location = :id";
		StoreProducts storeproducts = (StoreProducts) currentSession.createQuery(hql).setParameter("id", id).setParameter("product", product).getSingleResult();
		return storeproducts;
		
	}

	@Override
	public void addStoreProduct(StoreProducts storeproducts) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Serializable i =currentSession.save(storeproducts);
		
	}

	@Override
	public void updateStoreProduct(StoreProducts storeproducts) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(storeproducts);
		
	}

	@Override
	public boolean deleteStoreProduct(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		StoreProducts storeproducts= getStoreProductById(id);
		if(storeproducts!=null) {
			currentSession.delete(storeproducts);
			return true;
		}
		return false;
	}

	@Override
	public List<StoreProducts> get(int pageStart, int pageEnd) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from StoreProducts",StoreProducts.class);
		query.setFirstResult(pageStart);
        query.setMaxResults(pageEnd);
        List<StoreProducts> storeproducts = query.getResultList();
		return storeproducts;
	}
	
	@Override
	public List<StoreProducts> get(int locationId) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from StoreProducts where location = :locationId",StoreProducts.class);
		List<StoreProducts> storeproducts =  query.setParameter("locationId", locationId).getResultList();
		return storeproducts;
	}




}

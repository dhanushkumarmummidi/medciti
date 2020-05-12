package com.technocrat.product.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMethod;

import com.technocrat.product.Bean.Product;

@Repository
public class ProductDao implements ProductDaoI {

	@Autowired
	private EntityManager entityManager;

	public List<Product> get(String name) {
		Session currentsession = entityManager.unwrap(Session.class);
		List<Product> product = currentsession.createQuery("from Product", Product.class).getResultList();
		return product;
	}

	
	@Override
	public Product getProductByName(String name) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from Product where name =:name ";
		Product product = (Product) currentSession.createQuery(hql).setParameter("name", name).getSingleResult();
		return product;
	}

	
	public void addProduct(Product product){
		Session currentSession = entityManager.unwrap(Session.class);
		Serializable i =currentSession.save(product);
		
	}
	
	@Override
	public void updateProduct(Product product) {
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println(product);
		
		currentSession.update(product);
		
	}
	
	@Override
	public boolean deleteProduct(String name) {
		Session currentSession = entityManager.unwrap(Session.class);
		Product product= getProductByName(name);
		if(product!=null) {
			currentSession.delete(product);
			return true;
		}
		return false;
		
	}
	

	
	@Override
	public List<Product> get(int pageStart, int pageEnd) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from Product",Product.class);
		query.setFirstResult(pageStart);
        query.setMaxResults(pageEnd);
        List<Product> product = query.getResultList();
		return product;
	}

	@Override
	public List<Product> get() {
		Session currentsession = entityManager.unwrap(Session.class);
		List<Product> product = currentsession.createQuery("from Product", Product.class).getResultList();
		return product;
	}
}

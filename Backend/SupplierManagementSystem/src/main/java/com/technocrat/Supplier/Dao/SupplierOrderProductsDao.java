package com.technocrat.Supplier.Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.technocrat.Supplier.Bean.Supplier;
import com.technocrat.Supplier.Bean.SupplierOrderProducts;

@Repository
public class SupplierOrderProductsDao implements SupplierOrderProductsDaoI {

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<SupplierOrderProducts> get() {
		Session currentsession = entityManager.unwrap(Session.class);
		List<SupplierOrderProducts> supplierorderproducts = currentsession.createQuery("from SupplierOrderProducts", SupplierOrderProducts.class).getResultList();
		return supplierorderproducts;
	}

	@Override
	public SupplierOrderProducts getSupplierOrderById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from SupplierOrderProducts where id =:id ";
		SupplierOrderProducts supplierorderproducts = (SupplierOrderProducts) currentSession.createQuery(hql).setParameter("id", id).getSingleResult();
		return supplierorderproducts;
	}

	@Override
	public List<SupplierOrderProducts> getSupplierOrderByIdSupplierOrder(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from SupplierOrderProducts where supplierorderid =:id ";
		List<SupplierOrderProducts> supplierorderproducts = (List<SupplierOrderProducts>) currentSession.createQuery(hql).setParameter("id", id).getResultList();
		return supplierorderproducts;
	}
	
	@Override
	public void addSupplierOrderProducts(SupplierOrderProducts supplierorderproducts) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(supplierorderproducts);
		//currentSession.flush();
	}

	@Override
	public void updateSupplierOrderProducts(SupplierOrderProducts supplierorderproducts) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(supplierorderproducts);
		
	}

	@Override
	public boolean deleteSupplierOrderProducts(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		SupplierOrderProducts supplierorderproducts= getSupplierOrderById(id);
		if(supplierorderproducts!=null) {
			currentSession.delete(supplierorderproducts);
			return true;
		}
		return false;
		
	}


	@Override
	public List<SupplierOrderProducts> get(int pageStart, int pageEnd) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from SupplierOrderProducts",SupplierOrderProducts.class);
		query.setFirstResult(pageStart);
        query.setMaxResults(pageEnd);
        List<SupplierOrderProducts> supplierorderproducts = query.getResultList();
		return supplierorderproducts;
	
	}

}

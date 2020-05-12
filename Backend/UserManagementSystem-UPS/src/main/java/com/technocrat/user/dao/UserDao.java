package com.technocrat.user.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.technocrat.user.model.User;
@Repository
public class UserDao implements UserDaoI {

	@Autowired
	private EntityManager entityManager;
		
	@Override
	public List<User> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		List<User> users = currentSession.createQuery("from User",User.class).getResultList();
		return users;
	
	}

	@Override
	public User get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from User s where s.id = :uId ";
		User user = (User) currentSession.createQuery(hql).setParameter("uId", id).getSingleResult();
		return user;
	}

	@Override
	public void saveUser(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		Serializable i =currentSession.save(user);
	}

	@Override
	public void updateUser(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(user);

	}
	
	@Override
	public boolean deleteUser(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		User user= get(id);
		if(user!=null) {
			currentSession.delete(user);
			return true;
		}
		return false;
		
	}
	

	
	@Override
	public List<User> get(int pageStart, int pageEnd) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from User",User.class);
		query.setFirstResult(pageStart);
        query.setMaxResults(pageEnd);
        List<User> users = query.getResultList();
		return users;
	}

	@Override
	public List<User> findByLocationId(int locationId) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from User s where s.locationId = :uId ";
		List<User> user = (List<User>) currentSession.createQuery(hql).setParameter("uId", locationId).getResultList();
		return user;
	}
	
	@Override
	public List<User> searchUsersByLocation(int locationId,String search) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from User s where s.locationId = :uId and s.name like :search ";
		List<User> user = (List<User>) currentSession.createQuery(hql).setParameter("uId", locationId).setParameter("search", "%"+search+"%").getResultList();
		return user;
	}

	@Override
	public List<User> searchUsers(String search) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from User s where s.name like :search ";
		List<User> user = (List<User>) currentSession.createQuery(hql).setParameter("search", "%"+search+"%").getResultList();
		return user;
	}
}

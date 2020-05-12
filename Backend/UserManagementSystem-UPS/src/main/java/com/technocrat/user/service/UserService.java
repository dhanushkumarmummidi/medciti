package com.technocrat.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technocrat.user.Bean.CreateUserBean;
import com.technocrat.user.Exceptions.PermissionDeniedException;
import com.technocrat.user.Exceptions.UserNotFoundException;
import com.technocrat.user.dao.UserDao;
import com.technocrat.user.dao.UserDaoI;
import com.technocrat.user.model.User;

@Service
public class UserService implements UserServiceI {
	@Autowired
	UserDaoI userDao ;

	@Transactional
	@Override
	public List<User> get() {
		return userDao.get();
	}
	@Transactional
	@Override
	public User get(int id) {
		return userDao.get(id);
	}
	@Transactional
	@Override
	public void saveUser(User user,int requestUserId) throws Exception {
		User requestUser = get(requestUserId);
		if(requestUser!=null) {
			if(requestUser.getAccess()==0 || requestUser.getAccess() == 2 || (requestUser.getAccess() == 1 && requestUser.getLocationId() == user.getLocationId())) {
				userDao.saveUser(user);
			}
			else {
				throw new PermissionDeniedException("User does not have permission to create a new user");
			}
		}
		else {
			throw new UserNotFoundException("No user found with id "+requestUserId);
		}
		

	}
	
	@Transactional
	@Override
	public void updateUser(User user,int requestUserId) throws Exception {
		User requestUser = get(requestUserId);
		if(requestUser!=null) {
			if(requestUser.getAccess()==0 || (requestUser.getAccess() == 1 && requestUser.getLocationId() == user.getLocationId()) || requestUserId == user.getId()) {
				userDao.updateUser(user);
			}
			else {
				throw new PermissionDeniedException("User does not have permission to update a the user");
			}
		}
		else {
			throw new UserNotFoundException("No user found with id "+requestUserId);
		}
		

	}
	
	@Transactional
	@Override
	public void deleteUser(int userID,int requestUserId) throws Exception {
		User requestUser = get(requestUserId);
		User updateUser = get(userID);
		if(requestUser!=null) {
			if(requestUser.getAccess()==0 || (requestUser.getAccess() == 1 && requestUser.getLocationId() == updateUser.getLocationId())) {
				userDao.deleteUser(updateUser.getId());
			}
			else {
				throw new PermissionDeniedException("User does not have permission to delete a the user");
			}
		}
		else {
			throw new UserNotFoundException("No user found with id "+requestUserId);
		}
		

	}
	

	
	@Override
	public List<User> getUsersByAccess(int userId) {
		
		User user = get(userId);
		if(user.getAccess()==1) {
			int locationId=user.getLocationId();
			return getUsersByLocation(locationId);
		}
		else {
			return get();
		}
	}
	
	@Transactional
	@Override
	public List<User> getUsersByLocation(int locationId){
		return userDao.findByLocationId(locationId);
	}
	@Transactional
	@Override
	public List<User> searchUsersByLocation(int locationId,String search){
		return userDao.searchUsersByLocation(locationId,search);
	}
	
	@Override
	public boolean updateUserAccess(int id, boolean access) {
		User user = get(id);
		try {
			if(access)
				user.setAccess(0);
			else
				user.setAccess(1);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<User> get(int pagestart, int pageEnd) {
		return userDao.get(pagestart, pageEnd);
	}
	@Transactional
	@Override
	public List<User> searchUsersByAccess(int userId, String search) {
		User user = get(userId);
		if(user.getAccess()==1) {
			int locationId=user.getLocationId();
			return searchUsersByLocation(locationId,search);
		}
		else {
			return userDao.searchUsers(search);
		}
	}

}

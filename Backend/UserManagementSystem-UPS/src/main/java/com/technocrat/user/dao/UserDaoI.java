package com.technocrat.user.dao;

import java.util.List;

import com.technocrat.user.model.User;

public interface UserDaoI {
	List<User> get(); 
	List<User> get(int pageStart,int pageEnd);
	User get(int id);
	void saveUser(User user);
	void updateUser(User user);
	boolean deleteUser(int id);
	List<User> findByLocationId(int locationId);
	List<User> searchUsersByLocation(int locationId, String search);
	List<User> searchUsers(String search);
	
}

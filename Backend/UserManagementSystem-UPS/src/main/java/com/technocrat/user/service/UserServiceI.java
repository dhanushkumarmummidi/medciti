package com.technocrat.user.service;

import java.util.List;

import com.technocrat.user.Bean.CreateUserBean;
import com.technocrat.user.Exceptions.UserNotFoundException;
import com.technocrat.user.model.User;

public interface UserServiceI {
	List<User> get(); 
	User get(int id);
	List<User> get(int pagestart,int pageEnd);
	boolean updateUserAccess(int id,boolean access);
	void saveUser(User user, int requestUserId) throws UserNotFoundException, Exception;
	void updateUser(User user, int requestUserId) throws Exception;
	void deleteUser(int user, int requestUserId) throws Exception;
	List<User> getUsersByAccess(int userId);
	List<User> getUsersByLocation(int locationId);
	List<User> searchUsersByAccess(int userId, String search);
	List<User> searchUsersByLocation(int locationId, String search);
}

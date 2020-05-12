package com.loginManagement.loginSecure.order.bean;

import com.loginManagement.loginSecure.UserManagement.model.User;

public class CreateNewUserBean {
	long requestUserId;
	User user;
	public long getRequestUserId() {
		return requestUserId;
	}
	public void setRequestUserId(long requestUserId) {
		this.requestUserId = requestUserId;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CreateNewUserBean [requestUserId=" + requestUserId + ", user=" + user + "]";
	}
	
}

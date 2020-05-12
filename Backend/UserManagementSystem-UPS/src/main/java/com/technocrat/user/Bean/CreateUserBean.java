package com.technocrat.user.Bean;

import com.technocrat.user.model.User;

public class CreateUserBean<I> {
	int requestUserId;
	I user;
	public int getRequestUserId() {
		return requestUserId;
	}
	public void setRequestUserId(int requestUserId) {
		this.requestUserId = requestUserId;
	}
	public I getUser() {
		return user;
	}
	public void setUser(I user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CreateUserBean [requestUserId=" + requestUserId + ", user=" + user + "]";
	}
	
}

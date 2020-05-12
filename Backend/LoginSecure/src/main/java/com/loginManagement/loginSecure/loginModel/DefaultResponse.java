package com.loginManagement.loginSecure.loginModel;

public class DefaultResponse<T> {
	private String status;
	private String description;
	private T data;
	
	public DefaultResponse(String status, String description, T data) {
		super();
		this.status = status;
		this.description = description;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "DefaultResponse [status=" + status + ", description=" + description + ", data=" + data + "]";
	}
	
	
}

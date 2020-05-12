package com.technocrats.order.beans;

public class ResponseBean<I> {
	int status;
	I data;
	String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public I getData() {
		return data;
	}
	public void setData(I data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseBean [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
	
	
}

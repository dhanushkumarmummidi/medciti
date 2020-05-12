package com.technocrats.order;

public class OrderNotFullfiled extends Exception {
	public OrderNotFullfiled(String errorMessage) {
        super(errorMessage);
    }
}

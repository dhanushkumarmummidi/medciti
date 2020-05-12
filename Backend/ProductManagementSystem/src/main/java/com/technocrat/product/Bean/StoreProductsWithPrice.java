package com.technocrat.product.Bean;

public class StoreProductsWithPrice extends StoreProducts {
	int price;
	public StoreProductsWithPrice(int id, String product, int location, int availablequantity, int requiredquantity,int price) {
		super(id,product,location,availablequantity,requiredquantity);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StoreProductsWithPrice [price=" + price + "]";
	}
	
}

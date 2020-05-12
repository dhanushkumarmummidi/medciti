package com.technocrats.order.beans;

import java.util.List;
import java.util.Set;

public class Bill {
	String pharmacist;
	String StoreName;
	String StoreAddress;
	String phoneNumber;
	int invoiceID;
	Set<Sales> products;
	int totalAmount;
	int numberOfProducts;
	public String getPharmacist() {
		return pharmacist;
	}
	public void setPharmacist(String pharmacist) {
		this.pharmacist = pharmacist;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public String getStoreAddress() {
		return StoreAddress;
	}
	public void setStoreAddress(String storeAddress) {
		StoreAddress = storeAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	public Set<Sales> getProducts() {
		return products;
	}
	public void setProducts(Set<Sales> products) {
		this.products = products;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getNumberOfProducts() {
		return numberOfProducts;
	}
	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}
	@Override
	public String toString() {
		return "Bill [pharmacist=" + pharmacist + ", StoreName=" + StoreName + ", StoreAddress=" + StoreAddress
				+ ", phoneNumber=" + phoneNumber + ", invoiceID=" + invoiceID + ", products=" + products
				+ ", totalAmount=" + totalAmount + ", numberOfProducts=" + numberOfProducts + "]";
	}
	
}

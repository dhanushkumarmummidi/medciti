package com.technocrats.order.beans;

public class StatisticsData {
	String totalprice;
	String dataofsale;
	
	public StatisticsData(String totalprice, String dataofsale) {
		super();
		this.totalprice = totalprice;
		this.dataofsale = dataofsale;
	}
	public StatisticsData(Long totalprice, String dataofsale) {
		super();
		this.totalprice = totalprice+"";
		this.dataofsale = dataofsale;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public String getDataofsale() {
		return dataofsale;
	}
	public void setDataofsale(String dataofsale) {
		this.dataofsale = dataofsale;
	}
	@Override
	public String toString() {
		return "StatisticsData [totalprice=" + totalprice + ", dataofsale=" + dataofsale + "]";
	}
	
}

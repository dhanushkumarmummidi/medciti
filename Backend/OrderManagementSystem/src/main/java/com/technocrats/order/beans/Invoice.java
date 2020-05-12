package com.technocrats.order.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id 
	@Column(name="id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="userid")
	int userid;
	
	@Column(name="location")
	int location;
	
	@Column(name="customerphone")
	String customerPhone;
	
	@Column(name="customername")
	String customerName;
	
	@Column(name="dataofsale", insertable = false, updatable = false)
	String dataofsale;
	
	@Column(name="totalprice")
	int totalprice;
	

	  @OneToMany(mappedBy = "invoiceId", cascade = CascadeType.ALL)
	 
	    private Set<Sales> salesList;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getLocation() {
		return location;
	}


	public void setLocation(int location) {
		this.location = location;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getDataofsale() {
		return dataofsale;
	}


	public void setDataofsale(String dataofsale) {
		this.dataofsale = dataofsale;
	}


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}


	public Set<Sales> getSalesList() {
		return salesList;
	}


	public void setSalesList(Set<Sales> salesList) {
		this.salesList = salesList;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Invoice [id=" + id + ", userid=" + userid + ", location=" + location + ", customerPhone="
				+ customerPhone + ", customerName=" + customerName + ", dataofsale=" + dataofsale + ", totalprice="
				+ totalprice + ", salesList=" + salesList + "]";
	}
	
}

package com.technocrat.Supplier.Bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "supplierorder")
public class Supplier {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "storeid")
	private int storeid;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "orderplaceddate")
	private Date orderplaceddate;
	
	
	 @JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "orderrequireddate")
	private Date orderrequireddate;
	
	 
	@Column(name = "isfullfilled")
	private int isfullfilled;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public Date getOrderplacedate() {
		return orderplaceddate;
	}
	public void setOrderplacedate(Date orderplacedate) {
		this.orderplaceddate = orderplaceddate;
	}
	public Date getOrderrequireddate() {
		return orderrequireddate;
	}
	public void setOrderrequireddate(Date orderrequireddate) {
		this.orderrequireddate = orderrequireddate;
	}
	public int getIsfullfilled() {
		return isfullfilled;
	}
	public void setIsfullfilled(int isfullfilled) {
		this.isfullfilled = isfullfilled;
	}
	
	public String toString() {
		return "Supplier [id=" + id + ", storeid=" + storeid + ", orderplaceddate=" + orderplaceddate + ", orderrequireddate="
				+ orderrequireddate + ", isfullfilled=" + isfullfilled +"]";
	}
}

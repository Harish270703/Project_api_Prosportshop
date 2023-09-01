package com.example.demo.Model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long orderNumber;
	private String totalPrice;
	
	
	public Order() {
		super();
	}


	public Order(Long id, Long orderNumber, String totalPrice) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.totalPrice = totalPrice;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}


	public String getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
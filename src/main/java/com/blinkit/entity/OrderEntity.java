package com.blinkit.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;

	private String orderStatus;
	private int finalPrice;

	@OneToOne(cascade = CascadeType.ALL)
	private OTPEntity otpEntity;

	@ManyToOne
	@JoinColumn(name = "custId")
	@JsonBackReference
	private CustomerEntity customerEntity;

	@OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Order_ItemEntity> itemEntities;

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public OTPEntity getOtpEntity() {
		return otpEntity;
	}

	public void setOtpEntity(OTPEntity otpEntity) {
		this.otpEntity = otpEntity;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public List<Order_ItemEntity> getItemEntities() {
		return itemEntities;
	}

	public void setItemEntities(List<Order_ItemEntity> itemEntities) {
		this.itemEntities = itemEntities;
	}

}

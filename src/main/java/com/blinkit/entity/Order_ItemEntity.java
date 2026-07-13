package com.blinkit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordered_items")
public class Order_ItemEntity {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;

	private Integer itemQnt;
	private Integer itemTotalPrice;

	@ManyToOne
	@JoinColumn(name = "orderId")
	@JsonBackReference
	private OrderEntity orderEntity;

	@ManyToOne
	@JoinColumn(name = "productId")
	@JsonBackReference
	private ProductEntity productEntity;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getItemQnt() {
		return itemQnt;
	}

	public void setItemQnt(Integer itemQnt) {
		this.itemQnt = itemQnt;
	}

	public Integer getItemTotalPrice() {
		return itemTotalPrice;
	}

	public void setItemTotalPrice(Integer itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

}

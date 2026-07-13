package com.blinkit.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	private String productName;
	private String description;
	private Integer productPrice;
	private Integer productQnt;
	private String productStatus;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	@JsonBackReference
	private CategoryEntitiy categoryEntitiy;

	@OneToMany(mappedBy = "productEntity")
	@JsonManagedReference
	private List<Order_ItemEntity> orderItems;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQnt() {
		return productQnt;
	}

	public void setProductQnt(Integer productQnt) {
		this.productQnt = productQnt;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public CategoryEntitiy getCategoryEntitiy() {
		return categoryEntitiy;
	}

	public void setCategoryEntitiy(CategoryEntitiy categoryEntitiy) {
		this.categoryEntitiy = categoryEntitiy;
	}

	public List<Order_ItemEntity> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Order_ItemEntity> orderItems) {
		this.orderItems = orderItems;
	}
}

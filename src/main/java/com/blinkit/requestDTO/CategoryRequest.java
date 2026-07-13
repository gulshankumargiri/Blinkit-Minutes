package com.blinkit.requestDTO;

import java.util.List;

import com.blinkit.entity.ProductEntity;

public class CategoryRequest {

	private String categoryName;
	private String categoryStatus;

	private List<ProductRequest> productReq;

	

	public List<ProductRequest> getProductReq() {
		return productReq;
	}

	public void setProductReq(List<ProductRequest> productReq) {
		this.productReq = productReq;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
}

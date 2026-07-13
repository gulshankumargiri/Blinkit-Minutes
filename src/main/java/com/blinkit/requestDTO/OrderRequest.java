package com.blinkit.requestDTO;

import java.util.List;

public class OrderRequest {
	private Long customerId;

	private List<Order_ItemRequest> items;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Order_ItemRequest> getItems() {
		return items;
	}

	public void setItems(List<Order_ItemRequest> items) {
		this.items = items;
	}
}

package com.blinkit.response;

import java.util.List;

public class Order_Response {

	private long orderId;
	private String orderStatus;
	private int finalPrice;
	private List<OrderItem_Response> items;
	private int otp;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public List<OrderItem_Response> getItems() {
		return items;
	}
	public void setItems(List<OrderItem_Response> items) {
		this.items = items;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}

}

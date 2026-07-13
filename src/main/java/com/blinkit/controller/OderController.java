package com.blinkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blinkit.requestDTO.OrderRequest;
import com.blinkit.response.Order_Response;
import com.blinkit.service.OrdersService;

@RestController
@RequestMapping("orders")
public class OderController {

	@Autowired
	OrdersService ordersService;

	@PostMapping("makeOrder")
	public Order_Response createOrder(@RequestBody OrderRequest orderRequest) {
		System.out.println("=========order creation hiited========");
		return ordersService.createOrder(orderRequest);
	}
}

package com.blinkit.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blinkit.requestDTO.CustomerLoginRequest;
import com.blinkit.requestDTO.CustomerRequest;
import com.blinkit.response.Customer_Response;
import com.blinkit.service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {

	final CustomerService customerService;

	CustomerController(CustomerService customerService) {

		this.customerService = customerService;
	}

	@PostMapping("register")
	public Customer_Response createNewCustomerDetails(@Validated @RequestBody CustomerRequest customerRequest) {

		System.out.println("Customer register triggered...");
		return customerService.registerCustomer(customerRequest);

	}

	@GetMapping("login")
	public Customer_Response doUserLogin(@RequestBody CustomerLoginRequest loginRequest) {

		return customerService.doLogin(loginRequest);

	}
}

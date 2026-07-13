package com.blinkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.config.MapperHandling;
import com.blinkit.entity.CustomerEntity;
import com.blinkit.repository.CustomerRepository;
import com.blinkit.requestDTO.CustomerLoginRequest;
import com.blinkit.requestDTO.CustomerRequest;
import com.blinkit.response.Customer_Response;

@Service
public class CustomerService {

	final MapperHandling handling;
	final CustomerRepository customerRepository;

	CustomerService(MapperHandling handling, CustomerRepository customerRepository) {
		this.handling = handling;
		this.customerRepository = customerRepository;
	}

	// registering customer
	public Customer_Response registerCustomer(CustomerRequest customerRequest) {

		if (customerRepository.findByCustEmail(customerRequest.getCustEmail()) != null) {
			throw new RuntimeException("Email already exists");
		}

		if (customerRepository.findByCustPhone(customerRequest.getCustPhone()) != null) {
			throw new RuntimeException("Phone number already exists");
		}
		if (customerRequest.getCustPhone() < 6000000000L || customerRequest.getCustPhone() > 9999999999L) {
			throw new RuntimeException("Invalid phone number");
		}

		if (!(customerRequest.getPassword().equals(customerRequest.getConfirmPassword()))) {
			throw new RuntimeException(" Password mismatch Enter correct password");

		}
		CustomerEntity ent = handling.getCustomerEntity(customerRequest);
		ent = customerRepository.save(ent);
		return handling.getCustomerResponse(ent);

	}

	// login

	public Customer_Response doLogin(CustomerLoginRequest loginRequest) {

		if (loginRequest.getEmail() == null) {
			throw new RuntimeException("Email is null");

		}
		if (loginRequest.getPassword() == null) {
			throw new RuntimeException("Password is null");

		}

		CustomerEntity user = customerRepository.findByCustEmail(loginRequest.getEmail());
		if (user == null) {
			throw new RuntimeException("User not found");
		} else if (!(user.getPassword().equals(loginRequest.getPassword()))) {
			throw new RuntimeException("Password is invalid ");
		} else {

			System.out.println("User Loggein Successfully");
			return handling.getCustomerResponse(user);
		}

	}
}

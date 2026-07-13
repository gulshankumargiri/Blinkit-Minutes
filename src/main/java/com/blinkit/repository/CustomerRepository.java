package com.blinkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkit.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	CustomerEntity findByCustPhone(Long custPhone);

	CustomerEntity findByCustEmail(String custEmail);

}

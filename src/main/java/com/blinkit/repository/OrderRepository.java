package com.blinkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkit.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}

package com.blinkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkit.entity.Order_ItemEntity;

public interface OrderItemRepository extends JpaRepository<Order_ItemEntity, Long> {

}

package com.blinkit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blinkit.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	@Query("SELECT p FROM ProductEntity p WHERE p.productStatus = 'AVAILABLE'")
	List<ProductEntity> getAllAvailableProducts();
}

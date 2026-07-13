package com.blinkit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blinkit.entity.CategoryEntitiy;

public interface CategoryRepository extends JpaRepository<CategoryEntitiy, Long> {

	// find by name
	CategoryEntitiy findByCategoryName(String name);

	// get available category or Active category
	@Query("SELECT c FROM CategoryEntitiy c WHERE c.categoryStatus = 'ACTIVE'")
	List<CategoryEntitiy> getAllAvailableCategory();

	// find by id then update

	CategoryEntitiy findByCategoryId(Long id);
}

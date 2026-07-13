package com.blinkit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blinkit.requestDTO.CategoryRequest;
import com.blinkit.response.Category_Response;
import com.blinkit.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	// get all categories list
	@GetMapping("")
	public List<Category_Response> getAllAvailableCategory() {

		return categoryService.getAllActiceCategory();
	}

	// creating new category
	@PostMapping("category")
	public Category_Response createNewCategory(@RequestBody CategoryRequest categoryRequest) {
		return categoryService.createCategory(categoryRequest);
	}

	// updating category
	@PutMapping("update/{categoryId}")
	public Category_Response updateCategory(@PathVariable("categoryId") Long id,
			@RequestBody CategoryRequest categoryRequest) {

		System.out.println("===========update hitted==========");
		return categoryService.updateCategory(id, categoryRequest);
	}

	// Deleting with soft update
	@DeleteMapping("delete/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") Long id) {
		System.out.println("===========Delete hitted==========");

		return categoryService.softDeleteOfCategory(id);
	}

	// Creating product with 1 category

	@PostMapping("addProducts")
	public Category_Response addProductsToCategory(@RequestBody CategoryRequest categoryRequest) {
		System.out.println("=========== addProductsToCategory hitted==========");

		return categoryService.saveCategoryWithProducts(categoryRequest);

	}

}

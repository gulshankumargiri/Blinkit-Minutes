package com.blinkit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.config.MapperHandling;
import com.blinkit.entity.CategoryEntitiy;
import com.blinkit.entity.ProductEntity;
import com.blinkit.repository.CategoryRepository;
import com.blinkit.requestDTO.CategoryRequest;
import com.blinkit.requestDTO.ProductRequest;
import com.blinkit.response.Category_Response;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	MapperHandling handling;

	// Create New Category
	public Category_Response createCategory(CategoryRequest categoryRequest) {

		CategoryEntitiy ent = categoryRepository.findByCategoryName(categoryRequest.getCategoryName());

		if (ent != null) {
			System.out.println(ent.getCategoryName());
			System.out.println(ent.getCategoryId());

			return handling.getCategoryResponse(ent);
		} else {

			ent = handling.getCategoryEntity(categoryRequest);

			ent = categoryRepository.save(ent);
			System.out.println("Category saved");

			return handling.getCategoryResponse(ent);
		}
	}

	// update category if exist change otherwise creates new
	public Category_Response updateCategory(Long id, CategoryRequest categoryRequest) {

		CategoryEntitiy category = categoryRepository.findByCategoryId(id);

//		CategoryEntitiy category = categoryRepository.findByCategoryName(categoryRequest.getCategoryName());

		if (category == null) {

			System.out.println("There is no any category with this id");
			throw new RuntimeException("Category Not Found");

		} else {

			handling.updateCategoryEntity(categoryRequest, category);

			category = categoryRepository.save(category);

			System.out.println(" category with this id " + id + " Got updated...");

			return handling.getCategoryResponse(category);
		}

	}

	// delete Category
	public String softDeleteOfCategory(long id) {

		Optional<CategoryEntitiy> category = categoryRepository.findById(id);

		if (category.isPresent()) {

			CategoryEntitiy entity = category.get();
			entity.setCategoryStatus("IN-Active");
			categoryRepository.save(entity);
			return "Category Deactivated!! , to Activate update the Category with their name.";
		} else {
			return "Category Not Found !!";
		}

	}

	// get All Available/Active Categories
	public List<Category_Response> getAllActiceCategory() {

		List<CategoryEntitiy> categories = categoryRepository.getAllAvailableCategory();

		List<Category_Response> categoryList = new ArrayList<Category_Response>();
		for (CategoryEntitiy entity : categories) {

			Category_Response resp = handling.getCategoryResponse(entity);

			categoryList.add(resp);

		}

		return categoryList;
	}

	// create List of products in one go with single category
	public Category_Response saveCategoryWithProducts(CategoryRequest categoryRequest) {

		CategoryEntitiy category = categoryRepository.findByCategoryName(categoryRequest.getCategoryName());

		if (category == null) {
			
			category = handling.getCategoryEntity(categoryRequest);
			System.out.println("-------New cateogry saved----------");
		}

		List<ProductEntity> productList = category.getProductEntity();

		if (productList == null) {
			productList = new ArrayList<ProductEntity>();
		}

		for (ProductRequest request : categoryRequest.getProductReq()) {
			ProductEntity entity = handling.getProductEntity(request);
			entity.setCategoryEntitiy(category);
			productList.add(entity);

		}

		category.setProductEntity(productList);

		categoryRepository.save(category);

		return handling.getCategoryResponse(category);
	}
}

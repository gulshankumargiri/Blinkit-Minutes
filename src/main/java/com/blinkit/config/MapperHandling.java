package com.blinkit.config;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blinkit.entity.CategoryEntitiy;
import com.blinkit.entity.CustomerEntity;
import com.blinkit.entity.OrderEntity;
import com.blinkit.entity.Order_ItemEntity;
import com.blinkit.entity.ProductEntity;
import com.blinkit.requestDTO.CategoryRequest;
import com.blinkit.requestDTO.CustomerRequest;
import com.blinkit.requestDTO.ProductRequest;
import com.blinkit.response.Category_Response;
import com.blinkit.response.Customer_Response;
import com.blinkit.response.OrderItem_Response;
import com.blinkit.response.Order_Response;
import com.blinkit.response.Product_Response;

@Component
public class MapperHandling {
	@Autowired
	ModelMapper modelMapper;

	// product Handling 
	public ProductRequest getProductRequest(ProductEntity productEntity) {
		return modelMapper.map(productEntity, ProductRequest.class);
	}

	public Product_Response getProductResponse(ProductEntity productEntity) {
		return modelMapper.map(productEntity, Product_Response.class);
	}

	public ProductEntity getProductEntity(ProductRequest productRequest) {
		return modelMapper.map(productRequest, ProductEntity.class);
	}

	public ProductEntity getProductEntityUsingResponse(Product_Response product_Response) {
		return modelMapper.map(product_Response, ProductEntity.class);
	}

	// Category Handling

	public CategoryEntitiy getCategoryEntity(CategoryRequest categoryRequest) {
		return modelMapper.map(categoryRequest, CategoryEntitiy.class);
	}

	public Category_Response getCategoryResponse(CategoryEntitiy categoryEntitiy) {

		return modelMapper.map(categoryEntitiy, Category_Response.class);
	}

	// by using this mapper method - i am conveting all the fields of request in
	// entity and after that the entity has their generated id value , if i dont do
	// and use any other method from upper , then the [id] will became [null] and
	// updating
	// will not be happens anymore;
	public void updateCategoryEntity(CategoryRequest request, CategoryEntitiy entity) {
		modelMapper.map(request, entity);
	}

	//
	public Category_Response getResponseFromRequest(CategoryRequest categoryRequest) {
		return modelMapper.map(categoryRequest, Category_Response.class);
	}

	// Customer Handling

	// get customer entity by customer requests
	public CustomerEntity getCustomerEntity(CustomerRequest customerRequest) {
		return modelMapper.map(customerRequest, CustomerEntity.class);
	}

	// get customer response by customer entity
	public Customer_Response getCustomerResponse(CustomerEntity customerEntity) {
		return modelMapper.map(customerEntity, Customer_Response.class);
	}

	// for updating i need to convert [request] into [entity] and [entity] then will
	// able to use their generated value of [id].
	public void updateCustomerEntity(CategoryRequest request, CategoryEntitiy entity) {
		modelMapper.map(request, entity);
	} 

	// getting order entity

	public Order_Response getOrderResponse(OrderEntity entity) {
		return modelMapper.map(entity, Order_Response.class);
	}

	public OrderItem_Response getOrderItemResponse(Order_ItemEntity item) {

		return modelMapper.map(item, OrderItem_Response.class);
	}

}

package com.blinkit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.config.MapperHandling;
import com.blinkit.config.ModelMapperConfig;
import com.blinkit.entity.CategoryEntitiy;
import com.blinkit.entity.ProductEntity;
import com.blinkit.repository.CategoryRepository;
import com.blinkit.repository.ProductRepository;
import com.blinkit.requestDTO.ProductRequest;
import com.blinkit.response.Product_Response;

@Service
public class ProductService {

	private final ModelMapperConfig modelMapperConfig;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ModelMapper mapper;

	@Autowired
	MapperHandling mapperHandling;

	ProductService(ModelMapperConfig modelMapperConfig) {
		this.modelMapperConfig = modelMapperConfig;
	}

	// Creating Product
	public Product_Response createProduct(ProductRequest productRequest) {

		// 1st taking category
		CategoryEntitiy category = categoryRepository.findByCategoryName(productRequest.getCategoryName());

		// using mapper to map all fields of request to entity
		ProductEntity entity = mapperHandling.getProductEntity(productRequest);

		entity.setCategoryEntitiy(category);

		// saving entity in DB
		ProductEntity req = productRepository.save(entity);

		System.out.println("product created .......");

		Product_Response result = mapper.map(req, Product_Response.class);

		result.setCategoryName(req.getCategoryEntitiy().getCategoryName());

		return result;
	}

	// Deleting the product
	public String softDelete(long prodId) {

		ProductEntity entity = productRepository.findById(prodId)
				.orElseThrow(() -> new RuntimeException("Product Not Found!"));

		entity.setProductStatus("Not-Available");

		productRepository.save(entity);
		System.out.println("-------- Product-Delted-------");

		return "Product Disabled";

	}

	// update product
	public Product_Response updateProd(long id, ProductRequest productRequest) {

		ProductEntity entity = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("product not found"));
//		CategoryEntitiy category = categoryRepository.findByCategoryName(productRequest.getCategoryName());
		mapper.map(productRequest, entity);

		if (productRequest.getCategoryName() != null && !productRequest.getCategoryName().isBlank()) {

			CategoryEntitiy category = categoryRepository.findByCategoryName(productRequest.getCategoryName());

			if (category == null) {
				throw new RuntimeException("Category not found");
			}

			entity.setCategoryEntitiy(category);
		}
		entity = productRepository.save(entity);

		System.out.println("------got updated======");

		Product_Response prodRes = mapper.map(entity, Product_Response.class);

		prodRes.setCategoryName(entity.getCategoryEntitiy().getCategoryName());

		return prodRes;
	}

	// getting all products

	public List<Product_Response> getAllProductsHome() {

		List<ProductEntity> entities = productRepository.getAllAvailableProducts();

		List<Product_Response> respList = new ArrayList<Product_Response>();

		for (ProductEntity entity : entities) {

			Product_Response resp = mapperHandling.getProductResponse(entity);
			resp.setCategoryName(entity.getCategoryEntitiy().getCategoryName());
			respList.add(resp);
		}
		return respList;

	}
}

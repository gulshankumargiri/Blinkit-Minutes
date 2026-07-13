package com.blinkit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blinkit.entity.ProductEntity;
import com.blinkit.requestDTO.ProductRequest;
import com.blinkit.response.Product_Response;
import com.blinkit.service.ProductService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("product")
	public Product_Response creatProd(@RequestBody ProductRequest productRequest) {

		System.out.println("-------------ProductController.creatProd()==============");
		return productService.createProduct(productRequest);
	}

	@DeleteMapping("delete/{product_id}")
	public String deleteProduct(@PathVariable("product_id") long prodId) {

		System.out.println("--------Delting Product-------");
		return productService.softDelete(prodId);
	}

	@PutMapping("update/{product_id}")
	public Product_Response updateProd(@PathVariable("product_id") long id,
			@RequestBody ProductRequest productRequest) {

		System.out.println("-----update hitted---------");
		return productService.updateProd(id, productRequest);

	}

	@GetMapping("")
	public List<Product_Response> getAvailableProd() {

		return productService.getAllProductsHome();
	}

}

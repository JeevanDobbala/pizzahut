package com.pizzahut.pizzahutwebsite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzahut.pizzahutwebsite.entity.ProductEntity;
import com.pizzahut.pizzahutwebsite.services.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService ps;

	@PostMapping("/addProduct")
	public ProductEntity addProduct(@RequestBody ProductEntity pe) {
		pe = ps.addProduct(pe);
		return pe;
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable Long productId) {
		return ps.deleteProduct(productId);
	}

	@GetMapping("/getProductById/{productId}")
	public Optional<ProductEntity> getProductById(@PathVariable Long productId) {

		return ps.getProductById(productId);
	}

	@GetMapping("/getAllProducts")
	public List<ProductEntity> getAllProducts() {
		return ps.getAllProducts();
	}

}

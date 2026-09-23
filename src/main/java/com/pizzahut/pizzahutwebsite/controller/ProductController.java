package com.pizzahut.pizzahutwebsite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private ProductService ps;
 
	/* @Author : JeevanDobbala
	 * for adding the Product the below method is used 
	 * expecting the json data and returns the Message if failed and if succeed 
	 * it returns the product data
	 */
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody ProductEntity pe) {
		ProductEntity p = ps.addProduct(pe);
		if (p != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(p);
		}
		return ResponseEntity.badRequest().body("failed to add the product!");
	}

	
	/*@Author : JeevanDobbala
	 * for delete the Product the below method is used 
	 * expecting the json data and returns the Message if failed and if succeed 
	 * it returns "success message"
	 */
	
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable Long productId) {
		Optional<ProductEntity> pe = ps.getProductById(productId);

		if (pe.isPresent()) {
			ps.deleteProduct(productId);
			return "product deleted successfully!";
		}
		return "product deletion failed !";
	}

	/*@Author : JeevanDobbala
	 * for retrieving  the Product data the below method is used 
	 * expecting the json data and returns the Message if failed and if succeed 
	 * it returns the product data
	 */
	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable Long productId) {
		Optional<ProductEntity> pe = ps.getProductById(productId);

		if (pe.isPresent()) {
			return ResponseEntity.ok(pe.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found with the given productId");
	}

	/*@Author : JeevanDobbala
	 * for retrieving the all Products data the below method is used 
	 * expecting the json data and returns  
	 * it returns the product list data 
	 */
	
	@GetMapping("/getAllProducts")
	public List<ProductEntity> getAllProducts() {
		return ps.getAllProducts();
	}

}

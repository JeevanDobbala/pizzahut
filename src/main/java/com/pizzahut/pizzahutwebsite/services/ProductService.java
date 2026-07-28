package com.pizzahut.pizzahutwebsite.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pizzahut.pizzahutwebsite.entity.ProductEntity;
import com.pizzahut.pizzahutwebsite.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pr;
	
	public ProductEntity addProduct(@ModelAttribute ProductEntity pe) {
		pr.save(pe);
		return pe;
	}
	
	public String deleteProduct(Long productId) {
		pr.deleteById(productId);
		return "successfully deleted!";
	}
	
	public List<ProductEntity> getAllProducts(){
		List<ProductEntity> l=new ArrayList<>();
		l=pr.findAll();
		return l;
	}
	
	public Optional<ProductEntity> getProductById(Long productId) {
	    return pr.findById(productId);
	}

}

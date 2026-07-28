package com.pizzahut.pizzahutwebsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzahut.pizzahutwebsite.entity.ProductEntity;

@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {

	
	
}

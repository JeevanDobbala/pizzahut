package com.pizzahut.pizzahutwebsite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzahut.pizzahutwebsite.entity.FranchiseEntity;
import com.pizzahut.pizzahutwebsite.services.FranchiseService;

@RestController
public class FranchiseController {
	@Autowired
	FranchiseService franchiseService;

	@GetMapping("/getFranchiseNameById/{franchiseId}")
	public Optional<FranchiseEntity> getFranchiseNameById(@PathVariable Long franchiseId) {
		return franchiseService.getFranchiseById(franchiseId);
	}

	@PostMapping("/addFranchise")
	public FranchiseEntity addFranchise(@RequestBody FranchiseEntity ce) {
		return franchiseService.addFranchise(ce);
	}

	@DeleteMapping("/deleteFranchiseById/{franchiseId}")
	public String deleteFranchiseById(@PathVariable Long franchiseId) {
		return franchiseService.deleteFranchiseById(franchiseId);
	}

	@GetMapping("/getAllFranchises")
	public List<FranchiseEntity> getAllFranchises() {
		return franchiseService.getAllFranchises();
	}

	@PutMapping("/updateFranchiseById/{franchiseId}")
	public FranchiseEntity updateFranchiseById(@PathVariable Long franchiseId, @RequestBody FranchiseEntity franchise) {

		return franchiseService.updateFranchiseById(franchiseId, franchise);
	}
}

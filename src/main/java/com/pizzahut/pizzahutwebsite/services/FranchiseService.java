package com.pizzahut.pizzahutwebsite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzahut.pizzahutwebsite.entity.FranchiseEntity;
import com.pizzahut.pizzahutwebsite.repositories.FranchiseRepository;

@Service
public class FranchiseService {

	@Autowired
	FranchiseRepository franchiseRepository;

	public Optional<FranchiseEntity> getFranchiseById(Long companyId) {
		return franchiseRepository.findById(companyId);
	}

	public FranchiseEntity addFranchise(FranchiseEntity ce) {
		return franchiseRepository.save(ce);
	}

	public String deleteFranchiseById(Long companyId) {
		franchiseRepository.deleteById(companyId);
		return "deleted Successfully!";
	}
	
	public List<FranchiseEntity> getAllFranchises(){
		return franchiseRepository.findAll();
	}
	
	public FranchiseEntity updateFranchiseById(Long franchiseId, FranchiseEntity franchise) {

	    FranchiseEntity existingFranchise = franchiseRepository.findById(franchiseId)
	            .orElseThrow(() -> new RuntimeException("Franchise Not Found"));

	    existingFranchise.setFranchiseName(franchise.getFranchiseName());

	    return franchiseRepository.save(existingFranchise);
	}
}

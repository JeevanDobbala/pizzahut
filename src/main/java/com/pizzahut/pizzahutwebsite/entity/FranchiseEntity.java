package com.pizzahut.pizzahutwebsite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "franchise")
public class FranchiseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long franchiseId;
	
	@Column(nullable = false)
    private String franchiseName;

	public Long getFranchiseId() {
		return franchiseId;
	}

	public void setFranchiseId(Long franchiseId) {
		this.franchiseId = franchiseId;
	}

	public String getFranchiseName() {
		return franchiseName;
	}

	public void setFranchiseName(String farnchiseName) {
		this.franchiseName = farnchiseName;
	}

	
  
}

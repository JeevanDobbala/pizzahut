package com.pizzahut.pizzahutwebsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzahut.pizzahutwebsite.entity.PaymentTypeEntity;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentTypeEntity, Long>{

}

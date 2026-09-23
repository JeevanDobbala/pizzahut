package com.pizzahut.pizzahutwebsite.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.pizzahut.pizzahutwebsite.entity.PaymentTypeEntity;

@Service
public class PaymentService {
	public String addPaymentType() {

		return "adding payment failed!";
	}

	public PaymentTypeEntity getPaymentTypeById(@PathVariable Long PaymentId) {

		return null;
	}
	
	public List<PaymentTypeEntity> getAllPaymentTypes(@PathVariable Long PaymentId) {

		return null;
	}
	
	public PaymentTypeEntity deletePaymentTypeById(@PathVariable Long PaymentId) {
 
		return null;
	}

}

package com.pizzahut.pizzahutwebsite.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(nullable = false)
	private Double totalAmount;
	
	@Column(nullable = false)
	private LocalDate orderDate;
	
	@Column(nullable = false)
	private String orderType;
	
	 @ManyToOne
	 @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	 private UserEntity user;

	 public Long getOrderId() {
		 return orderId;
	 }

	 public void setOrderId(Long orderId) {
		 this.orderId = orderId;
	 }

	 public Double getTotalAmount() {
		 return totalAmount;
	 }

	 public void setTotalAmount(Double totalAmount) {
		 this.totalAmount = totalAmount;
	 }

	 public LocalDate getOrderDate() {
		 return orderDate;
	 }

	 public void setOrderDate(LocalDate orderDate) {
		 this.orderDate = orderDate;
	 }

	 public String getOrderType() {
		 return orderType;
	 }

	 public void setOrderType(String orderType) {
		 this.orderType = orderType;
	 }

	 public UserEntity getUser() {
		 return user;
	 }

	 public void setUser(UserEntity user) {
		 this.user = user;
	 }
	
	
}

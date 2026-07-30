package com.pizzahut.pizzahutwebsite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzahut.pizzahutwebsite.entity.OrderEntity;
import com.pizzahut.pizzahutwebsite.entity.UserEntity;
import com.pizzahut.pizzahutwebsite.repositories.OrderRepository;
import com.pizzahut.pizzahutwebsite.repositories.UserRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;

	public String addOrder(OrderEntity oe) {

		Long userId = oe.getUser().getUserId();
		UserEntity user = userRepository.findById(userId).orElse(null);

		if (user == null) {
			return "User not found!";
		}

		if (user.getActive() == 0) {
			return "User is inactive. Order cannot be placed!";
		}
		oe.setUser(user);
		OrderEntity orderEntity = orderRepository.save(oe);

		if (orderEntity != null) {
			return "Order Placed Successfully!";
		}
		return "Order is Unsuccessful!";

	}

	public Optional<OrderEntity> getOrderById(Long orderId) {
		return orderRepository.findById(orderId);

	}

	public List<OrderEntity> getAllOrders() {
		return orderRepository.findAll();
	}
}

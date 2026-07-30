package com.pizzahut.pizzahutwebsite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzahut.pizzahutwebsite.entity.OrderEntity;
import com.pizzahut.pizzahutwebsite.services.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService os;

	@PostMapping("/addOrder")
	public String addOrder(@RequestBody OrderEntity oe) {
		return os.addOrder(oe);
	}

	@GetMapping("/getAllOrders")
	public ResponseEntity<?> getAllOrders() {
		List<OrderEntity> list = os.getAllOrders();

		if (list == null || list.isEmpty()) {
			return ResponseEntity.ok("No recent orders found");
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getOrderById/{orderId}")
	public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
		Optional<OrderEntity> oe = os.getOrderById(orderId);
		if (oe.isPresent()) {
			return ResponseEntity.ok(oe.get());
		}
		return ResponseEntity.ok(" order not found!");
	}

}

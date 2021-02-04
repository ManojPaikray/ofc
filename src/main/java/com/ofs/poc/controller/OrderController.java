package com.ofs.poc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ofs.poc.dto.OrderHistoryResponse;
import com.ofs.poc.dto.OrderRequest;
import com.ofs.poc.dto.OrderResponse;
import com.ofs.poc.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/place/order")
	public ResponseEntity<OrderResponse> placeOrder(@Valid @RequestBody OrderRequest orderRequest) {
		return ResponseEntity.ok(orderService.placeOrder(orderRequest));
	}
	
	@GetMapping("/port")
	public String getPortNo() {
		return orderService.getPortNo();
	}
	
	@GetMapping("/order/history")
	public ResponseEntity<OrderHistoryResponse> getOrderHistory(Integer userId) {
		return ResponseEntity.ok(orderService.getOrderHistory(userId));
	}
}

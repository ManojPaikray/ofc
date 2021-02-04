package com.ofs.poc.service;

import com.ofs.poc.dto.OrderHistoryResponse;
import com.ofs.poc.dto.OrderRequest;
import com.ofs.poc.dto.OrderResponse;

public interface OrderService {
	public OrderResponse placeOrder(OrderRequest orderRequest);
	
	public String getPortNo();
	
	public OrderHistoryResponse getOrderHistory(Integer userId);
}

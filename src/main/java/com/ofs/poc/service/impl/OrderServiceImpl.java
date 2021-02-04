package com.ofs.poc.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ofs.poc.dto.FundTransferRequestDto;
import com.ofs.poc.dto.FundTransferResponse;
import com.ofs.poc.dto.OrderHistoryResponse;
import com.ofs.poc.dto.OrderItem;
import com.ofs.poc.dto.OrderRequest;
import com.ofs.poc.dto.OrderResponse;
import com.ofs.poc.feignclient.FundTransferClient;
import com.ofs.poc.mapper.OrderMapper;
import com.ofs.poc.model.FoodItem;
import com.ofs.poc.model.FoodOrder;
import com.ofs.poc.repository.FoodItemsRepository;
import com.ofs.poc.repository.OrderItemRepository;
import com.ofs.poc.repository.OrderRepository;
import com.ofs.poc.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private FoodItemsRepository itemRepository;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private FundTransferClient fundTransferClient;
	
	@Override
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		List<Integer> priceList = orderRequest.getItems().stream().map(this :: getItemPrice).collect(Collectors.toList());
		
		OrderResponse orderResponse = new OrderResponse();
		FoodOrder order = new FoodOrder();
		order.setOrderItems(orderMapper.mapObject(orderRequest));
		order.setTotalAmt(priceList.stream().mapToInt(Integer :: intValue).sum());
		order.setOrderDate(LocalDateTime.now().toString());
		order.setUserId(orderRequest.getUserId());
		
		FundTransferRequestDto fundTransferRequestDto = new FundTransferRequestDto();
		fundTransferRequestDto.setAmount(order.getTotalAmt().doubleValue());
		fundTransferRequestDto.setFromAccount(orderRequest.getFormAccNumber());
		fundTransferRequestDto.setToAccount(4560002);
		
		ResponseEntity<FundTransferResponse> response = fundTransferClient.transferFund(fundTransferRequestDto);
		if("FAIL".equalsIgnoreCase(response.getBody().getResponseStatus())) {
			orderResponse.setMessage(response.getBody().getMessage());
			orderResponse.setStatus(response.getBody().getResponseStatus());
			
			return orderResponse;
		} else  {
			FoodOrder foodOrder = orderRepository.save(order);
		
			orderResponse.setStatus(response.getBody().getResponseStatus());
			orderResponse.setMessage("Order placed successfully, our delivery boy will contact you shortly.");
			orderResponse.setOrderId(foodOrder.getOredrId());
			
		return orderResponse;
		}
	}
	
	public Integer getItemPrice(OrderItem orderItem) {
		Optional<FoodItem> foodItems= itemRepository.findById(orderItem.getFoodItemId());
		if(foodItems.isPresent()) {
			return foodItems.get().getPrice() * orderItem.getQuantity();
		}
		
		return 0;
	}

	@Override
	public String getPortNo() {
		return fundTransferClient.getPortNo();
	}

	@Override
	public OrderHistoryResponse getOrderHistory(Integer userId) {
		List<FoodOrder>	foodOrderList = orderRepository.findFirst5ByUserIdOrderByOrderDateDesc(userId);
		OrderHistoryResponse orderHistoryResponse = new OrderHistoryResponse();
		
		if(!foodOrderList.isEmpty()) {
			orderHistoryResponse.setOrders(foodOrderList);
			orderHistoryResponse.setStatus("SUCCESS");
			orderHistoryResponse.setMessage("Success");
		} else {
			orderHistoryResponse.setStatus("FAIL");
			orderHistoryResponse.setMessage("User Id does not exsist.");
		}
		
		return orderHistoryResponse;
	}

}

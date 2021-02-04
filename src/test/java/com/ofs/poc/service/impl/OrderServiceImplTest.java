package com.ofs.poc.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ofs.poc.dto.FundTransferRequestDto;
import com.ofs.poc.dto.FundTransferResponse;
import com.ofs.poc.dto.OrderHistoryResponse;
import com.ofs.poc.dto.OrderItem;
import com.ofs.poc.dto.OrderRequest;
import com.ofs.poc.dto.OrderResponse;
import com.ofs.poc.feignclient.FundTransferClient;
import com.ofs.poc.mapper.OrderMapper;
import com.ofs.poc.model.FoodOrder;
import com.ofs.poc.repository.FoodItemsRepository;
import com.ofs.poc.repository.OrderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceImplTest {
	
	@InjectMocks
	private OrderServiceImpl orderServiceImpl;
	
	@Mock
	private OrderRepository orderRepository;
	
	@Mock
	private FoodItemsRepository itemRepository;
	
	@Mock
	private OrderMapper orderMapper;
	
	@Mock
	private FundTransferClient fundTransferClient;
	
	FundTransferRequestDto fundTransferRequestDto;
	FundTransferResponse fundTransferResponse;
	OrderRequest orderRequest;
	OrderItem orderItem;
	FoodOrder foodOrder;
	
	@Before
	public void setup() {
		foodOrder = new FoodOrder();
		foodOrder.setOrderDate("date");
		foodOrder.setOredrId(UUID.randomUUID());
		foodOrder.setTotalAmt(101);
		foodOrder.setUserId(10);
		
		orderItem = new OrderItem();
		orderItem.setFoodItemId(111);
		orderItem.setQuantity(1);
		orderItem.setVendorId(100);
		
		orderRequest = new OrderRequest();
		orderRequest.setFormAccNumber(1000);
		orderRequest.setUserId(10);
		orderRequest.setItems(List.of(orderItem));
		
		fundTransferRequestDto = new FundTransferRequestDto();
		fundTransferRequestDto.setToAccount(1001);
		fundTransferRequestDto.setFromAccount(1000);
		fundTransferRequestDto.setAmount(Double.valueOf(100));
		
		fundTransferResponse = new FundTransferResponse();
		fundTransferResponse.setAvailableBalance(10000); 
		fundTransferResponse.setMessage("TEST");
		fundTransferResponse.setResponseStatus("OK");
		fundTransferResponse.setTransactionId(UUID.randomUUID());
	}
	
	@Test
	public void placeOrderTest() {
		when(fundTransferClient.transferFund(Mockito.any())).thenReturn(ResponseEntity.of(Optional.of(fundTransferResponse)));
		Mockito.when(orderRepository.save(Mockito.any())).thenReturn(foodOrder);
		OrderResponse orderResponse = orderServiceImpl.placeOrder(orderRequest);
		
		assertEquals(orderResponse.getStatus(), "OK");
	}

	@Test
	public void getOrderHistoryTest() {
		when(orderRepository.findFirst5ByUserIdOrderByOrderDateDesc(Mockito.anyInt())).thenReturn(List.of(foodOrder));
		OrderHistoryResponse response = orderServiceImpl.getOrderHistory(101);
		assertEquals(response.getStatus(), "SUCCESS");
	}
}

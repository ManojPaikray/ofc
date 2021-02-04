package com.ofs.poc.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderResponse {
	private UUID orderId;
	
	private String message;
	
	private String status;
	
}

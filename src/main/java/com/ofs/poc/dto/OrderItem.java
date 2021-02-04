package com.ofs.poc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderItem {
	private Integer foodItemId;
	
	private Integer vendorId;
	
	private Integer quantity;
}

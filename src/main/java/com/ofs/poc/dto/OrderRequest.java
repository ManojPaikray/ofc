package com.ofs.poc.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderRequest {
	private List<OrderItem> items;
	
	private Integer formAccNumber;
	
	private Integer userId;
}

package com.ofs.poc.dto;

import java.util.List;

import com.ofs.poc.model.FoodOrder;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class OrderHistoryResponse {
	private List<FoodOrder> orders;
	
	private String status;
	
	private String message;
}

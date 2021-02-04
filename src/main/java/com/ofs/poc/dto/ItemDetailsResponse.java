package com.ofs.poc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDetailsResponse {
	private String vendorName;
	
	private String itemName;
	
	private Integer itemId;
	
	private Integer vendorId;
	
	private Integer price;
}

package com.ofs.poc.service;

import java.util.List;

import com.ofs.poc.dto.ItemDetailsResponse;

public interface FoodService {
	public List<ItemDetailsResponse> getItemDetails(String  itemName);
}

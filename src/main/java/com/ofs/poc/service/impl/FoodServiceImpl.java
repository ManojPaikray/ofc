package com.ofs.poc.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofs.poc.dto.ItemDetailsResponse;
import com.ofs.poc.model.FoodItem;
import com.ofs.poc.model.Vendor;
import com.ofs.poc.repository.FoodItemsRepository;
import com.ofs.poc.repository.VendorRepository;
import com.ofs.poc.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodItemsRepository itemRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Override
	public List<ItemDetailsResponse> getItemDetails(String itemName) { 
		List<FoodItem> foodItems= itemRepository.findByItemNameContains(itemName);
		
		return foodItems.stream().map(this :: getItemDetailsResponse).collect(Collectors.toList());
	}

	public ItemDetailsResponse getItemDetailsResponse(FoodItem foodItem) {
		
		Optional<Vendor> vendor = vendorRepository.findById(foodItem.getVendorId());
		ItemDetailsResponse itemDetailsResponse = new ItemDetailsResponse();
		itemDetailsResponse.setItemId(foodItem.getId());
		itemDetailsResponse.setItemName(foodItem.getItemName());
		itemDetailsResponse.setVendorName(vendor.get().getVendorName());
		itemDetailsResponse.setPrice(foodItem.getPrice());
		itemDetailsResponse.setVendorId(vendor.get().getId());
		
		return itemDetailsResponse;
	}
}

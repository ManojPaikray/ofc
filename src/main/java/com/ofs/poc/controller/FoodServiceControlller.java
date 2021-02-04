package com.ofs.poc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ofs.poc.dto.ItemDetailsResponse;
import com.ofs.poc.service.FoodService;

@RestController
public class FoodServiceControlller {
	@Autowired
	private FoodService foodService;
	
	@GetMapping("/search/food/items")
	public ResponseEntity<List<ItemDetailsResponse>> getItemDetails(@Valid @RequestParam String itemName) {
		return ResponseEntity.ok(foodService.getItemDetails(itemName));
	}
}

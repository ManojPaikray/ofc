package com.ofs.poc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ofs.poc.model.FoodItem;

public interface FoodItemsRepository extends CrudRepository<FoodItem, Integer>{

	List<FoodItem> findByItemNameContains(String itemName);

}

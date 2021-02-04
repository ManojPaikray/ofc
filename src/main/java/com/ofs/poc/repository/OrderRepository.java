package com.ofs.poc.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.ofs.poc.model.FoodOrder;

public interface OrderRepository extends CrudRepository<FoodOrder, UUID>{
	public List<FoodOrder> findFirst5ByUserIdOrderByOrderDateDesc(Integer userId);
}

package com.ofs.poc.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.ofs.poc.model.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, UUID>{

}

package com.ofs.poc.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ofs.poc.dto.OrderRequest;
import com.ofs.poc.model.OrderItem;

@Component
public class OrderMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public List<OrderItem> mapObject(OrderRequest request) {
		return mapper.map(request.getItems(), new TypeToken<List<OrderItem>>(){}.getType());
	}
}

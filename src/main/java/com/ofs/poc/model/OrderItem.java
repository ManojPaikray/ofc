package com.ofs.poc.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItem {
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID orderItemId;
	
	private Integer foodItemId;
	
	private Integer quantity;
	
	private Integer vendorId;
	
}

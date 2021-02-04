package com.ofs.poc.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItem {
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(initialValue = 900001, name = "ACCNUM_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ITEM_SEQ", strategy = GenerationType.AUTO)
	private UUID orderItemId;
	
	private Integer foodItemId;
	
	private Integer quantity;
	
	private Integer vendorId;
	
}

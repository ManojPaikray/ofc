package com.ofs.poc.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FoodOrder {
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(initialValue = 1110001, name = "ACCNUM_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ORDER_SEQ", strategy = GenerationType.AUTO)
	private UUID oredrId;
	
	private Integer userId;
	
	private Integer totalAmt;
	
	private String orderDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "order_id")
	private List<OrderItem> orderItems;	
}

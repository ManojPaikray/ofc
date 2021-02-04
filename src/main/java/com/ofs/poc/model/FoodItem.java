package com.ofs.poc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "ITEM")
public class FoodItem implements Serializable{

	private static final long serialVersionUID = 2816872224161699609L;
	
	@Id
	@Column(name = "ITEM_ID						")
	private Integer id;
		
	@Column(name = "NAME")
	private String itemName;
	
	@Column(name = "PRICE")
	private Integer price;
	
	@Column(name = "ISVEG")
	private String ISVEG;
	
	@Column(name = "VENDOR_ID")
	private Integer vendorId;
	
}

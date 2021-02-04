package com.ofs.poc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "FOOD_VENDOR")
public class Vendor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "VENDOR_ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String vendorName;
	
	@Column(name = "ADDRESS")
	private String vendorAddress;
	
	@Column(name = "PHONE")
	private Integer phone;
	
}

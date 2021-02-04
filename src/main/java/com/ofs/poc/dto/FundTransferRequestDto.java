package com.ofs.poc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FundTransferRequestDto {
	private Integer fromAccount;
	
	private Integer toAccount;
	
	private Double amount;
}

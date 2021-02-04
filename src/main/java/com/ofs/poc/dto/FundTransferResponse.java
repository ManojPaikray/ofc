package com.ofs.poc.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FundTransferResponse {
	private double availableBalance;
	
	private UUID transactionId;
	
	private String message;
	
	private String responseStatus;
}

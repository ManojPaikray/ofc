package com.ofs.poc.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ofs.poc.dto.FundTransferRequestDto;
import com.ofs.poc.dto.FundTransferResponse;

@FeignClient(name = "http://BANK-SERVICE/ibank")
public interface FundTransferClient {
	
	@PostMapping("/transfer/fund")
	public ResponseEntity<FundTransferResponse> transferFund(@RequestBody FundTransferRequestDto fundTransferRequestDto);

	@GetMapping("/port")
	public String getPortNo();
}

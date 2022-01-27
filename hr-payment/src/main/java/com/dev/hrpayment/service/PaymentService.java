package com.dev.hrpayment.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dev.hrpayment.entities.Payment;
import com.dev.hrpayment.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String worketHost;
	
	private RestTemplate restTemplate;
	
	
	public PaymentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	
	public Payment getPayment(long workId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", "" + workId);
		
		Worker worker = restTemplate.getForObject(worketHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
	
}

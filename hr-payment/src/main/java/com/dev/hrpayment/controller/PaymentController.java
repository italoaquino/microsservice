package com.dev.hrpayment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.hrpayment.entities.Payment;
import com.dev.hrpayment.service.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	private PaymentService service;
	
	public PaymentController(PaymentService service) {
		this.service = service;
	}
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = this.service.getPayment(workerId, days);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
}











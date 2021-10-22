package com.freecharge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.services.OfferService;
import com.freecharge.services.PaymentService;
import com.freecharge.services.PlanService;
import com.freecharge.services.UserService;

@RestController
@RequestMapping("/api/v1.0/mobrecharge/user/{uid}/plan/{pid}/offer/{oid}")
public class PaymentController {
	@Autowired
	UserService userService;
	
	@Autowired
	PlanService planService;
	
	@Autowired
	OfferService offerService;
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/")
	@PreAuthorize("hasRole('USER')")
	ResponseEntity<String> payment(@PathVariable Integer uid, @PathVariable Integer pid, @PathVariable Integer oid){
		
		if(!userService.isPresent(uid) || !planService.isPresent(pid) || !offerService.isPresent(oid))
			return new ResponseEntity<String>("Invalid Arguments", HttpStatus.BAD_REQUEST);
		else {
			paymentService.addTransaction(uid, pid, oid);
			return new ResponseEntity<String>("Transaction successful", HttpStatus.CREATED);
		}
	}

}

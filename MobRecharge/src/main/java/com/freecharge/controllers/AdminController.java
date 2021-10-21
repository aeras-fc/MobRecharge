package com.freecharge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.entities.Offer;
import com.freecharge.entities.Plan;
import com.freecharge.services.AdminService;
import com.freecharge.services.PlanService;

@RestController
@RequestMapping("/api/v1.0/mobrecharge/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	PlanService planService;
	
	@PostMapping("/plan/{pid}/offer")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> addOffer(@RequestBody Offer offer, @PathVariable Integer pid) {
		if(planService.isPresent(pid)) {
			adminService.addOffer(offer, pid);
			return new ResponseEntity<String>("Offer Added with ID: " + offer.getId(), HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>("Plan doesn't exist", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/plan")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> addPlan(@RequestBody Plan plan){
       adminService.addPlan(plan);
       return new ResponseEntity<String>("Plan added successfully with ID: " + plan.getId(), HttpStatus.CREATED);
	}

}

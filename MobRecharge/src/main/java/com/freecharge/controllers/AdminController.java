package com.freecharge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.entities.Offer;
import com.freecharge.entities.Plan;
import com.freecharge.services.AdminService;

@RestController
@RequestMapping("/api/v1.0/mobrecharge/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("/plan/{pid}/offer")
	public Integer addOffer(@RequestBody Offer offer, @PathVariable Integer pid) {
		return adminService.addOffer(offer, pid);
	}
	
	@PostMapping("/plan")
	public Integer addPlan(@RequestBody Plan plan){
        return adminService.addPlan(plan);
	}

}

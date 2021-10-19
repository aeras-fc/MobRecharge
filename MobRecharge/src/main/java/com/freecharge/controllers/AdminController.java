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
	
	@PostMapping("/addOffer")
	public Integer addOffer(@RequestBody Offer offer) {
		return adminService.addOffer(offer);
	}
	
	@PostMapping("offer/{oid}/plan")
	public Integer addPlan(@RequestBody Plan plan, @PathVariable Integer oid){
        return adminService.addPlan(plan, oid);
	}

}

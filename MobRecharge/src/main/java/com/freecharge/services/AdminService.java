package com.freecharge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freecharge.entities.Offer;
import com.freecharge.entities.Plan;
import com.freecharge.repos.OfferRepo;
import com.freecharge.repos.PlanRepo;

@Service
public class AdminService {
	@Autowired
	OfferRepo offerRepo;
	
	@Autowired
	PlanRepo planRepo;
	
	public Integer addOffer(Offer offer) {
		offerRepo.save(offer);
		return offer.getId();
	}
	public Integer addPlan(Plan plan, Integer oid) {
		Offer offer = offerRepo.findById(oid)
				.orElse(null);
		plan.setOffer(offer);
		
		planRepo.save(plan);
		return plan.getId();
	}

}

package com.freecharge.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.entities.Offer;
import com.freecharge.services.OfferService;

@RestController
@RequestMapping("/api/v1.0/mobrecharge/offer")
public class OfferController {
	
	@Autowired 
	OfferService offerService;
	
	@GetMapping("/")
	List<Offer> getAllOffers() {
		System.out.println("called");
		return offerService.getAll();
	}
	
	@PutMapping("/{oid}")
	public Optional<Offer> updateOffer(@RequestBody Offer offer, @PathVariable Integer oid) {
		return offerService.update(offer, oid);
	}
	
	@DeleteMapping("/{oid}")
	public String deleteOffer(@PathVariable Integer oid) {
		return offerService.delete(oid);
	}
	
	@GetMapping("/{oid}")
	public Offer getOffer(@PathVariable Integer oid) {
		return offerService.offer(oid);
	}

}

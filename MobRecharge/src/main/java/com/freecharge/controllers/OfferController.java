package com.freecharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity <List<Offer>> getAllOffers() {
		System.out.println("called");
		List <Offer> offerList = offerService.getAll();
		if(offerList.isEmpty())
			return new ResponseEntity<List<Offer>>(offerList, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Offer>>(offerList, HttpStatus.FOUND);
	}
	
	@PutMapping("/{oid}")
	public ResponseEntity<String> updateOffer(@RequestBody Offer offer, @PathVariable Integer oid) {
		if(offerService.isPresent(oid)) {
			offerService.update(offer, oid);
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Offer not available", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{oid}")
	public ResponseEntity<String> deleteOffer(@PathVariable Integer oid) {
		if(offerService.isPresent(oid)) {
			offerService.delete(oid);
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		}
		else 
			return new ResponseEntity<String>("Offer not available", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{oid}")
	public ResponseEntity<Offer> getOffer(@PathVariable Integer oid) {
		if(offerService.isPresent(oid)) 
			return new ResponseEntity<Offer>(offerService.offer(oid), HttpStatus.OK);
		else
			return new ResponseEntity<Offer>((Offer) null, HttpStatus.NOT_FOUND);
	}

}

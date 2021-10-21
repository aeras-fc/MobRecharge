package com.freecharge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freecharge.entities.Offer;
import com.freecharge.repos.OfferRepo;

@Service
public class OfferService {
	
	@Autowired
	OfferRepo offerRepo;
	
	public List<Offer> getAll() {
		return offerRepo.findAll();
	}
	
	public Optional<Offer> update(Offer offer, Integer oid) {
		Offer dbOffer = offerRepo.findById(oid).orElse(null);
		dbOffer.setCeilingValue(offer.getCeilingValue());
		dbOffer.setDescription(offer.getDescription());
        dbOffer.setDiscountPercentage(offer.getDiscountPercentage());
        dbOffer.setMinValue(offer.getMinValue());
        offerRepo.save(dbOffer);
		return offerRepo.findById(oid);
	}
	
	public String delete(Integer oid) {
		offerRepo.deleteById(oid);
		return "Offer deleted!";
	}
	
	public Offer offer(Integer oid) {
		return offerRepo.findById(oid).orElse(null);
	}
	
	public boolean isPresent(Integer id) {
		return offerRepo.existsById(id);
	}

}

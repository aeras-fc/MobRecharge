package com.freecharge.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freecharge.entities.Offer;
import com.freecharge.entities.Plan;
import com.freecharge.entities.Status;
import com.freecharge.entities.Transaction;
import com.freecharge.entities.User;
import com.freecharge.repos.OfferRepo;
import com.freecharge.repos.PlanRepo;
import com.freecharge.repos.TransactionRepository;
import com.freecharge.repos.UserRepository;

@Service
public class PaymentService {
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PlanRepo planRepo;
	
	@Autowired
	OfferRepo offerRepo;
	
	
	public Integer addTransaction(Integer uid, Integer pid, Integer oid) {
		
		User user = userRepo.findById(uid).orElse(null);
		Plan plan = planRepo.findById(pid).orElse(null);
		Offer offer = offerRepo.findById(oid).orElse(null);
		
		double amount;
		if(plan.getPrice() >= offer.getMinValue()) {
			double discountedAmt = (offer.getDiscountPercentage()/100.00)*plan.getPrice();
			amount = plan.getPrice() - Math.min(discountedAmt, offer.getCeilingValue());
		}
		else
			amount = plan.getPrice();
		
		Transaction transaction = new Transaction(
				new Date(),
				amount,
				Status.Successful,
				user,
				plan,
				offer
				);
				
		transactionRepo.save(transaction);
		return transaction.getId();
	}

}

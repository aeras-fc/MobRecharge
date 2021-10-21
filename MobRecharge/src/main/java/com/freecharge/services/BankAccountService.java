package com.freecharge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freecharge.entities.BankAccount;
import com.freecharge.entities.User;
import com.freecharge.repos.BankAccountRepository;
import com.freecharge.repos.UserRepository;

@Service
public class BankAccountService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	BankAccountRepository bankAccountRepository;
	
	public List<BankAccount> getUserBankAccounts(Integer uid) {
		return bankAccountRepository.findByUserUid(uid);
	}
	
	public String addBankAccount(BankAccount bankAccount,Integer uid) {
		User user = userRepository.findById(uid)
                .orElse(null);
		bankAccount.setUser(user);
		bankAccountRepository.save(bankAccount);
		return "Bank Added";
		
	}	
	public String deleteBankAccountOfUserByBid(Integer uid, Integer bid) {
		if(userRepository.findById(uid).isPresent()) {
			bankAccountRepository.deleteById(bid);
			return "deleted";
		}
		return "user not exist";
	}

}

package com.freecharge.services;

import java.util.List;

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
	public List<BankAccount> getUserBankAccountDetails(Integer uid) {
		return bankAccountRepository.findByUid(uid);
	}
	public BankAccount addBankAccountOfUser(BankAccount bankAccount,Integer uid) {
		User dbuser=userRepository.findOne(uid);
		bankAccount.setUser(dbuser);
		return bankAccountRepository.save(bankAccount);
	}
	public String deleteBankAccountOfUserByBid(Integer uid, Integer bid) {
		if(userRepository.findById(uid).isPresent()) {
			bankAccountRepository.deleteById(bid);
			return "deleted";
		}
		return "user not exist";
	}

}

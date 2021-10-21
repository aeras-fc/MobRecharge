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
	
	public List<BankAccount> getByUid(Integer uid) {
		return bankAccountRepository.findByUserUid(uid);
	}
	
	public Integer add(BankAccount bankAccount,Integer uid) {
		User user = userRepository.findById(uid)
                .orElse(null);
		bankAccount.setUser(user);
		bankAccountRepository.save(bankAccount);
		return bankAccount.getBid();
	}	
	
	public boolean isPresent(Integer id) {
		return bankAccountRepository.existsById(id);
	}
	
	public void delete(Integer id) {
		bankAccountRepository.deleteById(id);
		return;
	}
	
	public BankAccount getByBid(Integer bid) {
		return bankAccountRepository.getById(bid);
	}
	

}

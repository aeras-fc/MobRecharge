package com.freecharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.entities.BankAccount;
import com.freecharge.services.BankAccountService;

@RestController
@RequestMapping("/api/v1.0/mobrecharge/user/{uid}/bankaccount")
public class BankAccountController {
	@Autowired
	BankAccountService bankAccountService;
	
	
	@GetMapping(value="/")
	List<BankAccount> getBankAccount(@PathVariable Integer uid) {
		return bankAccountService.getUserBankAccounts(uid);
	}
	
	@PostMapping(value="/")
	String addBankAccount(@RequestBody BankAccount bankAccount, @PathVariable Integer uid) {
		bankAccountService.addBankAccount(bankAccount, uid);
		System.out.println("Post Bank Account added!");
		return "Bank Added";
	}
	
//	@DeleteMapping(value="/{bid}")
//	String deleteBankAccountOfUserByBid(@PathVariable Integer uid,@PathVariable Integer bid) {
//		return bankAccountService.deleteBankAccountOfUserByBid(uid,bid);
//	}
}

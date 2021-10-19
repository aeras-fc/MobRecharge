package com.freecharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	List<BankAccount> getUserBankAccountDetails(@PathVariable Integer uid) {
		return bankAccountService.getUserBankAccountDetails(uid);
	}
	@PostMapping(value="/")
	BankAccount addBankAccountOfUser(@RequestBody BankAccount bankAccount,@PathVariable Integer uid) {
		return bankAccountService.addBankAccountOfUser(bankAccount,uid);
	}
	@DeleteMapping(value="/{bid}")
	String deleteBankAccountOfUserByBid(@PathVariable Integer uid,@PathVariable Integer bid) {
		return bankAccountService.deleteBankAccountOfUserByBid(uid,bid);
	}
}

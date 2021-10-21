package com.freecharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.entities.BankAccount;
import com.freecharge.services.BankAccountService;
import com.freecharge.services.UserService;

@RestController
@RequestMapping("/api/v1.0/mobrecharge/user/{uid}/bankaccount")
public class BankAccountController {
	@Autowired
	BankAccountService bankService;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping(value="/")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	ResponseEntity <List<BankAccount>> getBankAccount(@PathVariable Integer uid) {
		if(!userService.isPresent(uid))
			return new ResponseEntity<List<BankAccount>>((List<BankAccount>) null, HttpStatus.BAD_REQUEST);
		else {
			List <BankAccount> listAccount = bankService.getByUid(uid);
			if(listAccount.isEmpty())
				return new ResponseEntity<List<BankAccount>>(listAccount, HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<List<BankAccount>>(listAccount, HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/")
	@PreAuthorize("hasRole('USER')")
	ResponseEntity<String> addBankAccount(@RequestBody BankAccount bankAccount, @PathVariable Integer uid) {
		if(!userService.isPresent(uid))
			return new ResponseEntity<String>("User not available", HttpStatus.BAD_REQUEST);
		else {
			bankService.add(bankAccount, uid);
			return new ResponseEntity<>("Bank Added Successfully with ID: " + bankAccount.getBid(), HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping(value="/{bid}")
	@PreAuthorize("hasRole('USER')")
	ResponseEntity<String> deleteBankAccountByBid(@PathVariable Integer uid, @PathVariable Integer bid) {
		if(!userService.isPresent(uid))
			return new ResponseEntity<String>("User not present!", HttpStatus.BAD_REQUEST);
		else {
			if(bankService.isPresent(bid) && bankService.getByBid(bid).getUser().getUid().equals(uid)) {
				bankService.delete(bid);
				return new ResponseEntity<String>("Bank Account Deleted", HttpStatus.OK);
			}
			else 
			   return new ResponseEntity<String>("Bank Account not available", HttpStatus.BAD_REQUEST);
		}	
	}
}

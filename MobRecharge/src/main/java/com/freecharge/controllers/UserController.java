package com.freecharge.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.entities.Transaction;
import com.freecharge.entities.User;

@RestController
@RequestMapping("/api/v1.0/mobrecharge/user")
public class UserController {
	@GetMapping(value="/")
	void getAllUsers() {
		System.out.println("get all users called");
	}
	@PostMapping(value="/")
	void createNewUser(@RequestBody User user) {
		System.out.println("new user creation called");
	}
	@GetMapping(value="/{uid}")
	void getUserById(@PathVariable Integer uid) {
		System.out.println("get users by id called");
	}
	@PutMapping(value="/{uid}")
	void updateUserById(@RequestBody User user,@PathVariable Integer uid) {
		System.out.println("update user called");
	}
	@DeleteMapping(value="/{uid}")
	void deleteUserById(@PathVariable Integer uid) {
		System.out.println("delete user called");
	}
	@GetMapping(value="/{uid}/bankaccount")
	void getUserBankAccountDetails(@PathVariable Integer uid) {
		System.out.println("get users bank details called");
	}
	@PostMapping(value="/{uid}/bankaccount")
	void addBankAccountOfUser(@RequestBody User user,@PathVariable Integer uid) {
		System.out.println("bank account add called");
	}
	@DeleteMapping(value="/{uid}/bankaccount/{bid}")
	void deleteBankAccountOfUserByBid(@PathVariable Integer uid,@PathVariable Integer bid) {
		System.out.println("delete user bank called");
	}
	@GetMapping(value="/{uid}/transaction")
	void getAllTransactions(@PathVariable Integer uid) {
		System.out.println("get transaction called");
	}
	@GetMapping(value="/{uid}/transaction/{tid}")
	void getTransactionById(@PathVariable Integer uid,@PathVariable Integer tid) {
		System.out.println("get transaction by id called");
	}
	@PostMapping(value="/{uid}/payment")
	void addPaymentDetails(@RequestBody Transaction transaction) {
		System.out.println("add payment details called");
	}
}

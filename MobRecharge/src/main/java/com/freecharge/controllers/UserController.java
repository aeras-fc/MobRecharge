package com.freecharge.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.entities.Plan;
import com.freecharge.entities.Transaction;
import com.freecharge.entities.User;
import com.freecharge.services.UserService;

@RestController
@RequestMapping("/api/v1.0/mobrecharge/user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping("getAll")
	List<User> getAllUsers() {
		System.out.println("called");
		return userService.getAllUsers();
	}
	
	@PostMapping(value="/signup")
	Integer createNewUser(@RequestBody User user) {
		return userService.createNewUser(user);
	}
	
	@GetMapping(value="/{uid}")
	Optional<User> getUserById(@PathVariable Integer uid) {
		return userService.getUserById(uid);
	}
	
	@PutMapping(value="/{uid}")
	Optional<User> updateUserById(@RequestBody User user,@PathVariable Integer uid) {
		return userService.updateUserById(user,uid);
	}
	
	@DeleteMapping(value="/{uid}")
	String deleteUserById(@PathVariable Integer uid) {
		return userService.deleteUserById(uid);
	}
	
	@GetMapping(value="/plans")
	public List<Plan> getAllPlans(){
		return userService.getAllPlans();
		
	}
	
	//to be put in transaction controller
	@GetMapping(value="/{uid}/transaction")
	void getAllTransactions(@PathVariable Integer uid) {
		System.out.println("get transaction called");
	}
	@GetMapping(value="/{uid}/transaction/{tid}")
	void getTransactionById(@PathVariable Integer uid,@PathVariable Integer tid) {
		System.out.println("get transaction by id called");
	}
	@PostMapping(value="/{uid}/plan/{pid}/offer/{oid}/payment")
	void addPaymentDetails(@RequestBody Transaction transaction) {
		System.out.println("add payment details called");
	}
}

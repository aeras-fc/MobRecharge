package com.freecharge.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	@GetMapping("/")
	ResponseEntity <List<User>> getAllUsers() {
		System.out.println("called");
		List <User> userList = userService.getAllUsers();
		if(userList.isEmpty())
			return new ResponseEntity<>(userList, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(userList, HttpStatus.FOUND);
	}
	
	@PostMapping(value="/signup")
	ResponseEntity<String> createUser(@RequestBody User user) {
		Integer id = userService.createNewUser(user);
		return new ResponseEntity<>("User added successfully with ID: " + id, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/{uid}")
	ResponseEntity<User> getUserById(@PathVariable Integer uid) {
		if(userService.isPresent(uid)) 
			return new ResponseEntity<User>(userService.getUserById(uid), HttpStatus.OK);
		else
			return new ResponseEntity<User>((User) null, HttpStatus.NOT_FOUND);	
	}
	
	@PutMapping(value="/{uid}")
	ResponseEntity<HttpStatus> updateUserById(@RequestBody User user,@PathVariable Integer uid) {
		if(userService.isPresent(uid)) {
			userService.updateUserById(user, uid);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value="/{uid}")
	ResponseEntity<HttpStatus> deleteUserById(@PathVariable Integer uid) {
		if(userService.isPresent(uid)) {
			userService.deleteUserById(uid);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/plans")
	ResponseEntity <List<Plan>> getAllPlans(){
		List <Plan> planList = userService.getAllPlans();
		if(planList.isEmpty())
			return new ResponseEntity<>(planList, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(planList, HttpStatus.FOUND);
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

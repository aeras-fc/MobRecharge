package com.freecharge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.entities.Plan;
import com.freecharge.entities.Transaction;
import com.freecharge.entities.User;
import com.freecharge.services.PaymentService;
import com.freecharge.services.PlanService;
import com.freecharge.services.UserService;

@RestController
@RequestMapping("/api/v1.0/mobrecharge/user")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	PlanService planService;

	@Autowired
	PaymentService paymentService;

	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<List<User>> getAllUsers() {
		System.out.println("called");
		List<User> userList = userService.getAll();
		if (userList.isEmpty())
			return new ResponseEntity<>(userList, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(userList, HttpStatus.FOUND);
	}

	@GetMapping(value = "/{uid}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	ResponseEntity<User> getUserById(@PathVariable Integer uid) {
		if (userService.isPresent(uid))
			return new ResponseEntity<User>(userService.getById(uid), HttpStatus.OK);
		else
			return new ResponseEntity<User>((User) null, HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/{uid}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	ResponseEntity<HttpStatus> updateUserById(@RequestBody User user, @PathVariable Integer uid) {
		if (userService.isPresent(uid)) {
			userService.updateById(user, uid);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value = "/{uid}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	ResponseEntity<HttpStatus> deleteUserById(@PathVariable Integer uid) {
		if (userService.isPresent(uid)) {
			userService.deleteById(uid);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/plans")
	ResponseEntity<List<Plan>> getAllPlans() {
		List<Plan> planList = planService.getAll();
		if (planList.isEmpty())
			return new ResponseEntity<>(planList, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(planList, HttpStatus.FOUND);
	}

	@GetMapping(value = "/{uid}/transactions")
	@PreAuthorize("hasRole('USER')")
	ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable Integer uid) {
		if (userService.isPresent(uid)) {
			List<Transaction> listTransaction = paymentService.getByUid(uid);
			if (listTransaction.isEmpty())
				return new ResponseEntity<List<Transaction>>(listTransaction, HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<List<Transaction>>(listTransaction, HttpStatus.FOUND);
		} else
			return new ResponseEntity<List<Transaction>>((List<Transaction>) null, HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/{uid}/transaction/{tid}")
	@PreAuthorize("hasRole('USER') or hasRole('Admin')")
	ResponseEntity<List<Transaction>> getTransactionById(@PathVariable Integer uid, @PathVariable Integer tid) {
		if (!userService.isPresent(uid))
			return new ResponseEntity<List<Transaction>>((List<Transaction>) null, HttpStatus.BAD_REQUEST);
		else {
			List<Transaction> listTransaction = paymentService.getByUid(uid);
			if (listTransaction.isEmpty())
				return new ResponseEntity<List<Transaction>>(listTransaction, HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<List<Transaction>>(listTransaction, HttpStatus.OK);
		}
	}

}

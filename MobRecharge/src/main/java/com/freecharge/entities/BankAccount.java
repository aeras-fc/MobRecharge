package com.freecharge.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankAccount {
	
	@Id
	@GeneratedtedValue(strategy=GenerationType.Identity)
	Integer bid;
	
	String bankName;
	String accountHolderName;
	String accountNumber;
	String createdDate;
	String updatedDate;
	double balance;
	


}

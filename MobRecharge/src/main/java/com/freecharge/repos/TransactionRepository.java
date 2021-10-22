package com.freecharge.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freecharge.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	List <Transaction> findByUserUid(Integer uid);

}

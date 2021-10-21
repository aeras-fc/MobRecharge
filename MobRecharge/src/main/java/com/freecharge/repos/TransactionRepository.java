package com.freecharge.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freecharge.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}

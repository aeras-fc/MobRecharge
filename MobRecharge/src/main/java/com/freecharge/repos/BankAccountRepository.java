package com.freecharge.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freecharge.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,Integer>{

	List<BankAccount> findByUserUid(Integer uid);
	
}

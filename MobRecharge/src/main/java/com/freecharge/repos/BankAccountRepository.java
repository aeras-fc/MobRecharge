package com.freecharge.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freecharge.entities.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer>{

	List<BankAccount> findByUserId(Integer uid);
	
}

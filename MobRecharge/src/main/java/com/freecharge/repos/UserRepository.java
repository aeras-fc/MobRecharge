package com.freecharge.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freecharge.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findOne(Integer uid);
}

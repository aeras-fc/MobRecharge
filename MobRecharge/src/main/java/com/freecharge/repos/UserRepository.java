package com.freecharge.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freecharge.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}

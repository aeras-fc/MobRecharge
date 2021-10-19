package com.freecharge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freecharge.entities.User;
import com.freecharge.repos.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Integer createNewUser(User user) {
		userRepository.save(user);
		return user.getUid();
	}

	public Optional<User> getUserById(Integer uid) {
		return userRepository.findById(uid);
	}

	public Optional<User> updateUserById(User user, Integer uid) {
		User dbuser=userRepository.findOne(uid);
		dbuser.setCreatedDate(user.getCreatedDate());
		dbuser.setDob(user.getDob());
		dbuser.setEmail(user.getEmail());
		dbuser.setFirstname(user.getFirstname());
		dbuser.setGender(user.getGender());
		dbuser.setLastname(user.getLastname());
		dbuser.setMobileNumber(user.getMobileNumber());
		dbuser.setPassword(user.getPassword());
		dbuser.setUpdatedDate(user.getUpdatedDate());
		return userRepository.findById(uid);
	}

	public String deleteUserById(Integer uid) {
		userRepository.deleteById(uid);
		return "deleted";
	}

}

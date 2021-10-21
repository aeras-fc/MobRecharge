package com.freecharge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freecharge.entities.User;
import com.freecharge.repos.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public Integer createNewUser(User user) {
		userRepository.save(user);
		return user.getUid();
	}

	public User getById(Integer uid) {
		return userRepository.findById(uid).orElse(null);
	}
	
	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User updateById(User user, Integer uid) {
		User dbuser = userRepository.findById(uid)
                .orElse(null);
		dbuser.setCreatedDate(user.getCreatedDate());
		dbuser.setDob(user.getDob());
		dbuser.setEmail(user.getEmail());
		dbuser.setFirstname(user.getFirstname());
		dbuser.setGender(user.getGender());
		dbuser.setLastname(user.getLastname());
		dbuser.setMobileNumber(user.getMobileNumber());;
		dbuser.setPassword(user.getPassword());
		dbuser.setUpdatedDate(user.getUpdatedDate());
		return userRepository.findById(uid).orElse(null);
	}

	public String deleteById(Integer uid) {
		userRepository.deleteById(uid);
		return "deleted";
	}
	
	public boolean isPresent(Integer id) {
		return userRepository.existsById(id);
	}

}

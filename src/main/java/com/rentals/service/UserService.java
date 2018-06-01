package com.rentals.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rentals.model.User;
import com.rentals.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findUserById(int id) {
		return userRepository.findOne(id);
	}
	
	public User saveUser(User user){
		userRepository.save(user);
		return user;
	}
	

	public void deleteUser(User user){
		userRepository.delete(user);
	}

	
	
}

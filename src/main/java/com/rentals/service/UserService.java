package com.rentals.service;

import java.util.logging.Level;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rentals.App;
import com.rentals.model.User;
import com.rentals.repository.UserRepository;

@Service
@Transactional
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findUserById(int id) {
		return userRepository.findOne(id);
	}

	public User saveUser(User user) {
		try {
			userRepository.save(user);
		} catch (Exception ex) {
			logger.error("Error in saving !!!" ,ex);
		}
		return user;
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}

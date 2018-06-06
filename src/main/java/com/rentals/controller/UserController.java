package com.rentals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.model.User;
import com.rentals.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		User user = userService.findUserById(id);
		if (user == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(path = "/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		if (newUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
		}
	}

	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<User> removeUser(@PathVariable("id") int id) {
		User user = userService.findUserById(id);
		if (user == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		else
			userService.deleteUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);

	}

}

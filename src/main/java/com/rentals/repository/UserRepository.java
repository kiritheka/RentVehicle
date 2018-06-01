package com.rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentals.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>  {
	
}

package com.rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentals.model.Book;
import com.rentals.model.Vehicle;

@Repository
public interface BookingRepository extends JpaRepository<Book,Integer> {
	
	Vehicle findVehicleById(int bookingId);

}

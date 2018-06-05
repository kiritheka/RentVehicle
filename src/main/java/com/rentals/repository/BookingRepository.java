package com.rentals.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rentals.model.Book;
import com.rentals.model.Vehicle;

@Repository
public interface BookingRepository extends JpaRepository<Book,Integer> {

	
	//@Query(value = "SELECT count(model_id) from book where book.model_id=:id AND book.is_booked = :count " , nativeQuery = true)
	//public int countBookedVehicleById(@Param("id") int id,@Param("count") int count);

	@Query(value = "SELECT * from book where book.model_id=:id AND book.is_booked = :isBooked " , nativeQuery = true)
	public ArrayList<Book> getListOfVehicleBookedByModelid(@Param("id") int id,@Param("isBooked") int isBooked);
	
	
}

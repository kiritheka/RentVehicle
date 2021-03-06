package com.rentals.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rentals.model.BookVehicle;

@Repository
public interface BookVehicleRepository extends JpaRepository<BookVehicle,Integer> {

	
	//@Query(value = "SELECT count(model_id) from book where book.model_id=:id AND book.is_booked = :count " , nativeQuery = true)
	//public int countBookedVehicleById(@Param("id") int id,@Param("count") int count);

	@Query(value = "SELECT * from book_vehicle  where book_vehicle.vehicle_model_id=:id AND book_vehicle.is_booked = :isBooked " , nativeQuery = true)
	public ArrayList<BookVehicle> getListOfVehicleBookedByModelid(@Param("id") int id,@Param("isBooked") int isBooked);
	
	
}

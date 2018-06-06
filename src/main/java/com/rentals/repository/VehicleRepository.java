package com.rentals.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rentals.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

	//@Query(value = "SELECT count(model_id) from vehicle where vehicle.model_id=:id " , nativeQuery = true)
	//public int countVehicleByModelId(@Param("id") int id);	
	
	@Query(value = "SELECT * from vehicle where vehicle.vehicle_model_id=:id " , nativeQuery = true)
	public ArrayList<Vehicle> getListOfVehicleByModelid(@Param("id") int id);	
}

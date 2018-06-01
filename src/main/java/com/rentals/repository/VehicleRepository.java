package com.rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rentals.model.Vehicle;
import com.rentals.model.VehicleModel;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

}

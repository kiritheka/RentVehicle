package com.rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rentals.model.ReturnVehicle;

@Repository
public interface ReturnVehicleRepository extends JpaRepository<ReturnVehicle,Integer> {

}

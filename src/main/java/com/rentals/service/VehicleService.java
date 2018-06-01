package com.rentals.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.rentals.model.Vehicle;
import com.rentals.model.VehicleModel;
import com.rentals.repository.VehicleModelRepository;
import com.rentals.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {

	private final VehicleRepository vehicleRepository;
	private final VehicleModelRepository vehicleModelRepository;
	
	public VehicleService(VehicleRepository vehicleRepository,
			VehicleModelRepository vehicleModelRepository) {
		this.vehicleRepository = vehicleRepository;
		this.vehicleModelRepository = vehicleModelRepository;
	}

	public Vehicle saveVehicle(Vehicle vehicle) {
		vehicle.setModelName(vehicleModelRepository.findOne(vehicle.getModelName().getModelId()));
		return vehicleRepository.save(vehicle);

	}

	public Vehicle findVehicleById(int id) {
		return vehicleRepository.findOne(id);
	}

	public List<Vehicle> findAllvehicle() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		for (Vehicle vehicle : vehicleRepository.findAll()) {
			vehicles.add(vehicle);
		}
		return vehicles;
	}

	public void deleteVehicle(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
	}

}

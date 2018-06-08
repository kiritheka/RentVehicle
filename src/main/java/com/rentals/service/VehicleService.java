package com.rentals.service;

import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.rentals.model.Vehicle;
import com.rentals.repository.VehicleModelRepository;
import com.rentals.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {
	private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);

	private final VehicleRepository vehicleRepository;
	private final VehicleModelRepository vehicleModelRepository;

	public VehicleService(VehicleRepository vehicleRepository, VehicleModelRepository vehicleModelRepository) {
		this.vehicleRepository = vehicleRepository;
		this.vehicleModelRepository = vehicleModelRepository;
	}

	public Vehicle saveVehicle(Vehicle vehicle) {
		Vehicle saveVehicle = null;
		try {
			vehicle.setVehicleModel(vehicleModelRepository.findOne(vehicle.getVehicleModel().getId()));
			saveVehicle = vehicleRepository.save(vehicle);
		} catch (Exception ex) {
			logger.error("Error in saving vehicle!!!", ex);
		}
		return saveVehicle;

	}

	public Vehicle findVehicleById(int id) {
		return vehicleRepository.findOne(id);
	}

	public List<Vehicle> findAllvehicle() {
		return vehicleRepository.findAll();
	}

}

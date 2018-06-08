package com.rentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.model.Vehicle;
import com.rentals.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@GetMapping(path = "/vehicle/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int id) {
		Vehicle vehicle = vehicleService.findVehicleById(id);
		if (vehicle == null)
			return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}

	@GetMapping(path = "/vehicle")
	public ResponseEntity<List<Vehicle>> getAllVehicle() {
		List<Vehicle> listOfVehicle = vehicleService.findAllvehicle();
		if (listOfVehicle == null)
			return new ResponseEntity<List<Vehicle>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Vehicle>>(listOfVehicle, HttpStatus.OK);
	}

	@PostMapping(path = "/vehicle")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		Vehicle vehicleNew = vehicleService.saveVehicle(vehicle);
		return new ResponseEntity<Vehicle>(vehicleNew, HttpStatus.CREATED);
	}

}

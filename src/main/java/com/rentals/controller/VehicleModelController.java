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

import com.rentals.model.VehicleModel;
import com.rentals.service.VehicleModelService;

@RestController
public class VehicleModelController {

	@Autowired
	VehicleModelService vehicleModelService;

	@PostMapping(path = "/vehiclemodel")
	public ResponseEntity<VehicleModel> addVehicleModel(@RequestBody VehicleModel vehicleModel) {
		VehicleModel vehicleModelNew = vehicleModelService.saveVehicleModel(vehicleModel);
		return new ResponseEntity<VehicleModel>(vehicleModelNew, HttpStatus.CREATED);
	}

	@GetMapping(path = "/vehiclemodel/{id}")
	public ResponseEntity<VehicleModel> getVehicleModelById(@PathVariable("id") int id) {
		VehicleModel vehicleModel = vehicleModelService.findVehicleModelById(id);
		if (vehicleModel == null)
			return new ResponseEntity<VehicleModel>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<VehicleModel>(vehicleModel, HttpStatus.OK);
	}

	@GetMapping(path = "/vehiclemodel")
	public ResponseEntity<List<VehicleModel>> getAllVehicleModel() {
		List<VehicleModel> listOfVehicleModel = vehicleModelService.findAllvehicleModel();
		if (listOfVehicleModel == null)
			return new ResponseEntity<List<VehicleModel>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<VehicleModel>>(listOfVehicleModel, HttpStatus.OK);
	}

	@DeleteMapping(value = "/vehiclemodel/{id}")
	public ResponseEntity<VehicleModel> removeVehicleModel(@PathVariable("id") int id) {
		VehicleModel vehicleModel = vehicleModelService.findVehicleModelById(id);
		if (vehicleModel == null)
			return new ResponseEntity<VehicleModel>(HttpStatus.NOT_FOUND);
		else
			vehicleModelService.deleteVehicleModel(vehicleModel);
		return new ResponseEntity<VehicleModel>(HttpStatus.OK);

	}
}

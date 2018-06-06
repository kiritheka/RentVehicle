package com.rentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.model.ReturnVehicle;
import com.rentals.service.ReturnVehicleService;

@RestController
public class ReturnVehicleController {
	@Autowired
	ReturnVehicleService returnVehicleService;

	
	@PostMapping(path = "/returnvehicle")
	public ResponseEntity<ReturnVehicle> returnVehicle(@RequestBody ReturnVehicle returnVehicle) {
		ReturnVehicle returnBookedVehicle = returnVehicleService.returnVehicle(returnVehicle);
		if(returnBookedVehicle!=null) {
		return new ResponseEntity<ReturnVehicle>(returnBookedVehicle, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<ReturnVehicle>(HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping(path = "/returnvehicle/{id}")
	public ResponseEntity<ReturnVehicle> getReturnedVehicleById(@PathVariable("id") int id) {
		ReturnVehicle returnVehicle = returnVehicleService.findReturnedVehicleById(id);
		if (returnVehicle == null)
			return new ResponseEntity<ReturnVehicle>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<ReturnVehicle>(returnVehicle, HttpStatus.OK);
	}

	@GetMapping(path = "/returnvehicle")
	public ResponseEntity<List<ReturnVehicle>> getAllReturnedVehicle() {
		List<ReturnVehicle> returningVehicleList = returnVehicleService.findAllReturnedvehicle();
		if (returningVehicleList == null)
			return new ResponseEntity<List<ReturnVehicle>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<ReturnVehicle>>(returningVehicleList, HttpStatus.OK);
	}
}

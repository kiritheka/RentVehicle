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

import com.rentals.model.Book;
import com.rentals.model.Returning;
import com.rentals.model.Vehicle;
import com.rentals.service.ReturningService;

@RestController
public class ReturningController {
	@Autowired
	ReturningService returningService;

	
	@PostMapping(path = "/return")
	public ResponseEntity<Returning> returnVehicle(@RequestBody Returning returnVehicle) {
		Returning returnVehicleNew = returningService.returnVehicle(returnVehicle);
		if(returnVehicleNew!=null) {
		return new ResponseEntity<Returning>(returnVehicleNew, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Returning>(HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping(path = "/return/{id}")
	public ResponseEntity<Returning> getReturnedVehicleById(@PathVariable("id") int id) {
		Returning returnVehicle = returningService.findReturnedVehicleById(id);
		if (returnVehicle == null)
			return new ResponseEntity<Returning>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Returning>(returnVehicle, HttpStatus.OK);
	}

	@GetMapping(path = "/return")
	public ResponseEntity<List<Returning>> getAllReturnedVehicle() {
		List<Returning> returningVehicleList = returningService.findAllReturnedvehicle();
		if (returningVehicleList == null)
			return new ResponseEntity<List<Returning>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Returning>>(returningVehicleList, HttpStatus.OK);
	}
}

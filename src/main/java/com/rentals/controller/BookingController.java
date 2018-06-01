package com.rentals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.model.Book;
import com.rentals.model.Vehicle;
import com.rentals.service.BookingService;
import com.rentals.service.VehicleService;

@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;

	@PostMapping(path = "/book")
	public ResponseEntity<Book> bookVehicle(@RequestBody Book bookVehicle) {
		Book bookVehicleNew = bookingService.bookVehicle(bookVehicle);
		if(bookVehicleNew!=null) {
		return new ResponseEntity<Book>(bookVehicleNew, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);

		}
	}
}

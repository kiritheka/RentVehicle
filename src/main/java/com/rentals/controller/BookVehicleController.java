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

import com.rentals.model.BookVehicle;
import com.rentals.service.BookVehicleService;

@RestController
public class BookVehicleController {

	@Autowired
	BookVehicleService bookVehicleService;

	@PostMapping(path = "/bookvehicle")
	public ResponseEntity<BookVehicle> bookVehicle(@RequestBody BookVehicle bookVehicle) {
		BookVehicle bookVehicleNew = bookVehicleService.bookVehicle(bookVehicle);
		if(bookVehicleNew!=null) {
		return new ResponseEntity<BookVehicle>(bookVehicleNew, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<BookVehicle>(HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping(path = "/bookvehicle/{id}")
	public ResponseEntity<BookVehicle> getBookingById(@PathVariable("id") int id) {
		BookVehicle book = bookVehicleService.findBookingById(id);
		if (book == null)
			return new ResponseEntity<BookVehicle>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<BookVehicle>(book, HttpStatus.OK);
	}

	@GetMapping(path = "/bookvehicle")
	public ResponseEntity<List<BookVehicle>> getAllBooking() {
		List<BookVehicle> bookingList = bookVehicleService.findAllBooking();
		if (bookingList == null)
			return new ResponseEntity<List<BookVehicle>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<BookVehicle>>(bookingList, HttpStatus.OK);
	}
}

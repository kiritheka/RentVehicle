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
	
	@GetMapping(path = "/book/{id}")
	public ResponseEntity<Book> getBookingById(@PathVariable("id") int id) {
		Book book = bookingService.findBookingById(id);
		if (book == null)
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@GetMapping(path = "/book")
	public ResponseEntity<List<Book>> getAllBooking() {
		List<Book> bookingList = bookingService.findAllBooking();
		if (bookingList == null)
			return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Book>>(bookingList, HttpStatus.OK);
	}
}

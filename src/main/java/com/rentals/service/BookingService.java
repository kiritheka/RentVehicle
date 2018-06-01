package com.rentals.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rentals.model.Book;
import com.rentals.model.Vehicle;
import com.rentals.repository.BookingRepository;
import com.rentals.repository.UserRepository;
import com.rentals.repository.VehicleModelRepository;
import com.rentals.repository.VehicleRepository;

@Service
@Transactional
public class BookingService {
	
	private final BookingRepository bookingRepository;
	private final UserRepository userRepository;
	private final VehicleRepository vehicleRepository;


	public BookingService(BookingRepository bookingRepository,UserRepository userRepository,VehicleRepository vehicleRepository) {
		this.bookingRepository = bookingRepository;
		this.userRepository=userRepository;
		this.vehicleRepository=vehicleRepository;
	}
	
	public Book bookVehicle(Book booking) {
		 Vehicle vehicle =bookingRepository.findVehicleById(booking.getVehicleId().getId());
		
		 for (Book book : bookingRepository.findAll()) {
			if ((book.getVehicleId()).equals(booking.getVehicleId())) {
				return null;
			}
		}
		 
		 if(vehicle == null) 
		 booking.setUserId(userRepository.findOne(booking.getUserId().getId()));
		booking.setVehicleId(vehicleRepository.findOne(booking.getVehicleId().getId()));
		return bookingRepository.save(booking);
	}
}

package com.rentals.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private final VehicleModelRepository vehicleModelRepository;

	public BookingService(BookingRepository bookingRepository, UserRepository userRepository,
			VehicleRepository vehicleRepository, VehicleModelRepository vehicleModelRepository) {
		this.bookingRepository = bookingRepository;
		this.userRepository = userRepository;
		this.vehicleRepository = vehicleRepository;
		this.vehicleModelRepository = vehicleModelRepository;
	}

	public Book bookVehicle(Book booking) {

		booking.setUserId(userRepository.findOne(booking.getUserId().getId()));
		booking.setVehicleModel(vehicleModelRepository.findOne(booking.getVehicleModel().getModelId()));

		ArrayList<Vehicle> listOfAllVehicleForModelId = vehicleRepository
				.getListOfVehicleByModelid(booking.getVehicleModel().getModelId());

		ArrayList<Book> listOfBookingForModelId = bookingRepository
				.getListOfVehicleBookedByModelid(booking.getVehicleModel().getModelId(), 1);
		ArrayList<Vehicle> listOfBookedVehicleForModelId = new ArrayList<Vehicle>();

		for (Book book : listOfBookingForModelId) {
			listOfBookedVehicleForModelId.add(book.getVehicle());
		}

		if (listOfAllVehicleForModelId.size() > listOfBookedVehicleForModelId.size()) {
			ArrayList<Vehicle> availableVehicleForBooking = new ArrayList<Vehicle>();
			for (Vehicle vehicle : listOfAllVehicleForModelId) {
				if (!listOfBookedVehicleForModelId.contains(vehicle)) {
					availableVehicleForBooking.add(vehicle);
				}
			}

			booking.setVehicle(vehicleRepository.findOne(availableVehicleForBooking.get(0).getId()));
			booking.setBooked(true);
			booking.setCreateDateTime(new Date());

			return bookingRepository.save(booking);

		} else {
			
			return null;
		}

	}

	public Book findBookingById(int id) {
		return bookingRepository.findOne(id);
	}

	public List<Book> findAllBooking() {
		List<Book> listOfBooking = new ArrayList<Book>();
		for (Book book : bookingRepository.findAll()) {
			listOfBooking.add(book);
		}
		return listOfBooking;
	}
}

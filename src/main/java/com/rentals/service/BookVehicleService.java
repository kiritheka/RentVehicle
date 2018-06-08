package com.rentals.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rentals.model.BookVehicle;
import com.rentals.model.Vehicle;
import com.rentals.repository.BookVehicleRepository;
import com.rentals.repository.UserRepository;
import com.rentals.repository.VehicleModelRepository;
import com.rentals.repository.VehicleRepository;

@Service
@Transactional
public class BookVehicleService {

	private final BookVehicleRepository bookVehicleRepository;
	private final UserRepository userRepository;
	private final VehicleRepository vehicleRepository;
	private final VehicleModelRepository vehicleModelRepository;

	public BookVehicleService(BookVehicleRepository bookingRepository, UserRepository userRepository,
			VehicleRepository vehicleRepository, VehicleModelRepository vehicleModelRepository) {
		this.bookVehicleRepository = bookingRepository;
		this.userRepository = userRepository;
		this.vehicleRepository = vehicleRepository;
		this.vehicleModelRepository = vehicleModelRepository;
	}

	public BookVehicle bookVehicle(BookVehicle bookVehicle) {

		bookVehicle.setUser(userRepository.findOne(bookVehicle.getUser().getId()));
		bookVehicle.setVehicleModel(vehicleModelRepository.findOne(bookVehicle.getVehicleModel().getId()));

		ArrayList<Vehicle> listOfAllVehicleForModelId = vehicleRepository
				.getListOfVehicleByModelid(bookVehicle.getVehicleModel().getId());

		ArrayList<BookVehicle> listOfBookingForModelId = bookVehicleRepository
				.getListOfVehicleBookedByModelid(bookVehicle.getVehicleModel().getId(), 1);
		ArrayList<Vehicle> listOfBookedVehicleForModelId = new ArrayList<Vehicle>();

		for (BookVehicle book : listOfBookingForModelId) {
			listOfBookedVehicleForModelId.add(book.getVehicle());
		}

		if (listOfAllVehicleForModelId.size() > listOfBookedVehicleForModelId.size()) {
			ArrayList<Vehicle> availableVehicleForBooking = new ArrayList<Vehicle>();
			for (Vehicle vehicle : listOfAllVehicleForModelId) {
				if (!listOfBookedVehicleForModelId.contains(vehicle)) {
					availableVehicleForBooking.add(vehicle);
				}
			}

			bookVehicle.setVehicle(vehicleRepository.findOne(availableVehicleForBooking.get(0).getId()));
			bookVehicle.setBooked(true);
			bookVehicle.setBookedDateTime(new Date());

			return bookVehicleRepository.save(bookVehicle);

		} else {
			return null;
		}

	}

	public BookVehicle findBookingById(int id) {
		return bookVehicleRepository.findOne(id);
	}

	public List<BookVehicle> findAllBooking() {
		return bookVehicleRepository.findAll();
	}
}

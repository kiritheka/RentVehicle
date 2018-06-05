package com.rentals.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rentals.model.Book;
import com.rentals.model.Returning;
import com.rentals.model.Vehicle;
import com.rentals.repository.BookingRepository;
import com.rentals.repository.ReturningRepository;
import com.rentals.repository.UserRepository;
import com.rentals.repository.VehicleModelRepository;
import com.rentals.repository.VehicleRepository;

@Service
@Transactional
public class ReturningService {

	private final BookingRepository bookingRepository;
	private final ReturningRepository returningRepository;

	public ReturningService(BookingRepository bookingRepository,ReturningRepository returningRepository) {
		this.bookingRepository = bookingRepository;
		this.returningRepository = returningRepository;
	}

	public Returning returnVehicle(Returning returning) {
		
		System.out.println("bfre"+returning.getBook());
		returning.setBook(bookingRepository.findOne(returning.getBook().getBookingId()));

		Book book = returning.getBook();
		returning.setReturnDateTime(new Date());
		
		if(book.isBooked()==true) {

		int pricePerHourForModel = book.getVehicleModel().getPricePerHour();
		long totalHourVehicleBooked =  (returning.getReturnDateTime().getTime()) -(book.getCreateDateTime().getTime());

		/* calculating total price from booking and returning time */
		double totalPrice = (((totalHourVehicleBooked / (60 * 60 * 1000) % 24) * pricePerHourForModel)+(((0.01666666666)*(totalHourVehicleBooked / (60 * 1000) % 60))*pricePerHourForModel));
		int totalPriceRoundedOff = (int) totalPrice;
		returning.setTotalRentalCost(totalPriceRoundedOff);
		book.setBooked(false);

		return returningRepository.save(returning);
		}else {
			return null;
		}

	}

	public Returning findReturnedVehicleById(int id) {
		return returningRepository.findOne(id);		
	}

	public List<Returning> findAllReturnedvehicle() {
		List<Returning> returnedVehicles = new ArrayList<Returning>();
		for (Returning returnedVehicle : returningRepository.findAll()) {
			returnedVehicles.add(returnedVehicle);
		}
		return returnedVehicles;
	}

}

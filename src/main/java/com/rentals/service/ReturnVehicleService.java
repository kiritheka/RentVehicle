package com.rentals.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.rentals.model.BookVehicle;
import com.rentals.model.ReturnVehicle;
import com.rentals.repository.BookVehicleRepository;
import com.rentals.repository.ReturnVehicleRepository;

@Service
@Transactional
public class ReturnVehicleService {

	private final BookVehicleRepository bookVehicleRepository;
	private final ReturnVehicleRepository returnVehicleRepository;

	public ReturnVehicleService(BookVehicleRepository bookingRepository, ReturnVehicleRepository returningRepository) {
		this.bookVehicleRepository = bookingRepository;
		this.returnVehicleRepository = returningRepository;
	}

	public ReturnVehicle returnVehicle(ReturnVehicle returning) {

		System.out.println("bfre" + returning.getBookVehicle());
		returning.setBookVehicle(bookVehicleRepository.findOne(returning.getBookVehicle().getId()));

		BookVehicle bookVehicle = returning.getBookVehicle();
		returning.setReturnDateTime(new Date());

		if (bookVehicle.isBooked() == true) {

			int pricePerHourForModel = bookVehicle.getVehicleModel().getPricePerHour();
			long totalHourVehicleBooked = (returning.getReturnDateTime().getTime())
					- (bookVehicle.getBookedDateTime().getTime());

			/* calculating total price from booking and returning time */
			double totalPrice = (((totalHourVehicleBooked / (60 * 60 * 1000) % 24) * pricePerHourForModel)
					+ (((0.01666666666) * (totalHourVehicleBooked / (60 * 1000) % 60)) * pricePerHourForModel));
			int totalRentalCost = (int) totalPrice;
			returning.setTotalRentalCost(totalRentalCost);
			bookVehicle.setBooked(false);

			return returnVehicleRepository.save(returning);
		} else {
			return null;
		}

	}

	public ReturnVehicle findReturnedVehicleById(int id) {
		return returnVehicleRepository.findOne(id);
	}

	public List<ReturnVehicle> findAllReturnedvehicle() {
		List<ReturnVehicle> returnedVehicles = new ArrayList<ReturnVehicle>();
		for (ReturnVehicle returnedVehicle : returnVehicleRepository.findAll()) {
			returnedVehicles.add(returnedVehicle);
		}
		return returnedVehicles;
	}

}

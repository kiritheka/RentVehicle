package com.rentals.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rentals.model.BookVehicle;
import com.rentals.model.ReturnVehicle;
import com.rentals.model.User;
import com.rentals.model.Vehicle;
import com.rentals.model.VehicleModel;
import com.rentals.model.VehicleType;
import com.rentals.service.BookVehicleService;
import com.rentals.service.ReturnVehicleService;
import com.rentals.service.UserService;
import com.rentals.service.VehicleModelService;
import com.rentals.service.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReturnVehicleeServiceTest {
	@Autowired
	VehicleService vehicleService;

	@Autowired
	VehicleModelService vehicleModelService;

	@Autowired
	UserService userService;

	@Autowired
	BookVehicleService bookVehicleService;

	@Autowired
	ReturnVehicleService returnVehicleService;

	ReturnVehicle returnVehicle;
	BookVehicle savedBooking;
	Date bookedDateTime;
	Date returnDateTime;
	int totalRentalCost;
	VehicleType vehicleType;

	@Before
	public void setUp() throws Exception {
		User user = new User(1, "Spring", "spring@gmail.com", "qwerty1234", "99424467");
		User savedUser = userService.saveUser(user);
		VehicleModel vehicleModel = new VehicleModel(1, "innova", 900000, vehicleType.FOUR_WHEELER);
		VehicleModel savedVehicleModel = vehicleModelService.saveVehicleModel(vehicleModel);
		Vehicle vehicle = new Vehicle(1, savedVehicleModel, "tn025678", "asdf56gh");
		Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
		BookVehicle bookVehicle = new BookVehicle(1, savedUser, savedVehicleModel, savedVehicle, bookedDateTime, true);
		savedBooking = bookVehicleService.bookVehicle(bookVehicle);
		returnVehicle = new ReturnVehicle(1, savedBooking, returnDateTime, totalRentalCost);
	}

	@Test
	public void testReturnVehicle() {
		ReturnVehicle savedreturning = returnVehicleService.returnVehicle(returnVehicle);

		assertEquals(1, savedreturning.getId());
		assertEquals(savedBooking.getId(), savedreturning.getBookVehicle().getId());
		assertNotNull(savedreturning.getReturnDateTime());
		assertNotNull(savedreturning.getTotalRentalCost());
	}

	@Test
	public void testFindReturnedVehicleById() {
		ReturnVehicle returningFoundById = returnVehicleService.findReturnedVehicleById(1);

		assertEquals(1, returningFoundById.getId());
		assertEquals(savedBooking.getId(), returningFoundById.getBookVehicle().getId());
		assertNotNull(returningFoundById.getReturnDateTime());
		assertNotNull(returningFoundById.getTotalRentalCost());
	}

	@After
	public void tearDown() {
		returnVehicle = null;
	}

}

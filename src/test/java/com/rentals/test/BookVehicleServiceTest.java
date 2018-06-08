package com.rentals.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import com.rentals.model.BookVehicle;
import com.rentals.model.User;
import com.rentals.model.Vehicle;
import com.rentals.model.VehicleModel;
import com.rentals.model.VehicleType;
import com.rentals.service.BookVehicleService;
import com.rentals.service.UserService;
import com.rentals.service.VehicleModelService;
import com.rentals.service.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookVehicleServiceTest {

	@Autowired
	VehicleService vehicleService;

	@Autowired
	VehicleModelService vehicleModelService;

	@Autowired
	BookVehicleService bookVehicleService;

	@Autowired
	UserService userService;

	VehicleModel vehicleModel;
	VehicleType vehicleType;
	BookVehicle bookVehicle;
	Vehicle vehicle;
	User user;

	VehicleModel savedVehicleModel;
	Vehicle savedVehicle;
	User savedUser;
	Date bookedDateTime;

	@Before
	public void setUp() throws Exception {
		user = new User(1, "Spring", "spring@gmail.com", "qwerty1234", "99424467");
		savedUser = userService.saveUser(user);
		vehicleModel = new VehicleModel(1, "innova", 45, vehicleType.FOUR_WHEELER);
		savedVehicleModel = vehicleModelService.saveVehicleModel(vehicleModel);
		vehicle = new Vehicle(1, savedVehicleModel, "tn025678", "asdf56gh");
		savedVehicle = vehicleService.saveVehicle(vehicle);
	}

	@Test
	public void testBookVehicle() {
		bookVehicle = new BookVehicle(1, savedUser, savedVehicleModel, savedVehicle, bookedDateTime, true);
		BookVehicle savedBooking = bookVehicleService.bookVehicle(bookVehicle);

		assertEquals(1, savedBooking.getId());
		assertEquals(savedUser.getId(), savedBooking.getUser().getId());
		assertEquals(savedVehicle.getId(), savedBooking.getVehicle().getId());
		assertEquals(true, savedBooking.isBooked());
		assertNotNull(savedBooking.getBookedDateTime());
	}

	@Test
	public void testFindBookingById() {
		BookVehicle bookingFoundById = bookVehicleService.findBookingById(1);

		assertEquals(1, bookingFoundById.getId());
		assertEquals(savedUser.getId(), bookingFoundById.getUser().getId());
		assertEquals(savedVehicle.getId(), bookingFoundById.getVehicle().getId());
		assertEquals(true, bookingFoundById.isBooked());
		assertNotNull(bookingFoundById.getBookedDateTime());

	}

	/*@Test
	public void testFindAllBooking() {
		List<BookVehicle> listOfBooking = bookVehicleService.findAllBooking();
		assertEquals(1, listOfBooking.get(0).getId());
	}*/
	
	/* saving user in bookingvehicle with null value */
	@Test(expected = NullPointerException.class)
	public void testingNotNullConstraint() {
		bookVehicleService.bookVehicle(new BookVehicle(2, null, savedVehicleModel, savedVehicle, bookedDateTime, true));
	}

	/* finding booking with unknown id */
	@Test(expected = NullPointerException.class)
	public void testFindBookingByUnknownId() {
		BookVehicle findBookingWithUnknownId = bookVehicleService.findBookingById(7);
		assertEquals(2, findBookingWithUnknownId.getId());

	}

	@After
	public void tearDown() {
		user = null;
		vehicleModel = null;
		vehicle = null;

	}

}

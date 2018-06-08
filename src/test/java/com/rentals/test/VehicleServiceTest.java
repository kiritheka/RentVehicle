package com.rentals.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import com.rentals.model.Vehicle;
import com.rentals.model.VehicleModel;
import com.rentals.model.VehicleType;
import com.rentals.service.VehicleModelService;
import com.rentals.service.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleServiceTest {

	@Autowired
	VehicleService vehicleService;

	@Autowired
	VehicleModelService vehicleModelService;

	VehicleModel vehicleModel;
	VehicleType vehicleType;
	Vehicle vehicle;
	VehicleModel savedVehicleModel;

	@Before
	public void setUp() throws Exception {
		vehicleModel = new VehicleModel(1, "innova", 45, vehicleType.FOUR_WHEELER);
		savedVehicleModel = vehicleModelService.saveVehicleModel(vehicleModel);
		vehicle = new Vehicle(1, savedVehicleModel, "tn025678", "asdf56gh");
	}

	@Test
	public void testSaveVehicle() {
		Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);

		assertEquals(1, savedVehicle.getId());
		assertEquals("tn025678", savedVehicle.getRegistrationNumber());
		assertEquals("asdf56gh", savedVehicle.getChassisNumber());
		assertEquals(savedVehicleModel.getId(), savedVehicle.getVehicleModel().getId());
	}

	@Test
	public void testFindVehicleById() {
		Vehicle vehicleFoundById = vehicleService.findVehicleById(1);

		assertEquals(1, vehicleFoundById.getId());
		assertEquals("tn025678", vehicleFoundById.getRegistrationNumber());
		assertEquals("asdf56gh", vehicleFoundById.getChassisNumber());
		assertEquals(savedVehicleModel.getId(), vehicleFoundById.getVehicleModel().getId());

	}

	@Test
	public void testFindAllvehicle() {
		List<Vehicle> listOfVehicle = vehicleService.findAllvehicle();
		assertEquals(1, listOfVehicle.size());

	}



	/* saving two vehicle with same RegistrationNumber or ChassisNumber */
	@Test(expected = TransactionSystemException.class)
	public void testUniqueConstraint() {
		vehicleService.saveVehicle(vehicle);
		vehicleService.saveVehicle(new Vehicle(2, savedVehicleModel, "tn025678", "asdf56gh"));
	}

	/* getting vehicle with unknown id */
	@Test(expected = NullPointerException.class)
	public void testFindvehicleByUnknownId() {
		Vehicle vehicleFoundByUnknownId = vehicleService.findVehicleById(7);
		assertEquals(null, vehicleFoundByUnknownId.getId());
		assertEquals("gh78996", vehicleFoundByUnknownId.getRegistrationNumber());
	}

	/*
	 * @Test public void testDeleteVehicle() { Vehicle vehicleToBeDeleted = new
	 * Vehicle(3, savedVehicleModel, "py78968", "zxcf69uy");
	 * vehicleService.deleteVehicle(vehicleToBeDeleted); Vehicle deletedvehicle =
	 * vehicleService.findVehicleById(2); assertNull(deletedvehicle); }
	 */

	@After
	public void tearDown() {
		vehicleModel = null;
		vehicle = null;
	}

}

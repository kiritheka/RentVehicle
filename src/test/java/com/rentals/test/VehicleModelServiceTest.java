package com.rentals.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rentals.model.User;
import com.rentals.model.VehicleModel;
import com.rentals.model.VehicleType;
import com.rentals.service.VehicleModelService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleModelServiceTest {

	@Autowired
	VehicleModelService vehicleModelService;

	static VehicleModel vehicleModel;
	static VehicleType vehicleType;

	@BeforeClass
	public static void setUp() throws Exception {
		vehicleModel = new VehicleModel(1, "innova", 45, vehicleType.FOUR_WHEELER);

	}

	@Test
	public void testSaveVehicleModel() {
		VehicleModel savedVehicleModel = vehicleModelService.saveVehicleModel(vehicleModel);

		assertEquals(1, savedVehicleModel.getId());
		assertEquals("innova", savedVehicleModel.getName());
		assertEquals(45, savedVehicleModel.getPricePerHour());
		assertEquals(vehicleType.FOUR_WHEELER, savedVehicleModel.getVehicleType());
	}

	@Test
	public void testFindVehicleModelById() {
		VehicleModel savedVehicleModelById = vehicleModelService.saveVehicleModel(vehicleModel);

		assertEquals(1, savedVehicleModelById.getId());
		assertEquals("innova", savedVehicleModelById.getName());
		assertEquals(45, savedVehicleModelById.getPricePerHour());
		assertEquals(vehicleType.FOUR_WHEELER, savedVehicleModelById.getVehicleType());

	}

	@Test
	public void testFindAllvehicleModel() {

		List<VehicleModel> listOfVehicleModel = vehicleModelService.findAllvehicleModel();
		assertEquals(1, listOfVehicleModel.size());

		VehicleModel savedVehicleModel = vehicleModelService.saveVehicleModel(vehicleModel);
		List<VehicleModel> listOfVehicleModels = vehicleModelService.findAllvehicleModel();
		assertEquals(2, listOfVehicleModels.size());
	}

	@Test
	public void testDeleteVehicleModel() {
		VehicleModel vehicleModelToBeDeleted = new VehicleModel(2, "re", 100, vehicleType.TWO_WHEELER);

		vehicleModelService.deleteVehicleModel(vehicleModelToBeDeleted);
		VehicleModel deletedvehicleModel = vehicleModelService.findVehicleModelById(2);
		assertNull(deletedvehicleModel);
	}

	/* saving vehiclemodel priceperhour column with null */
	@Test(expected = NullPointerException.class)
	public void testSavingColumnWithNull() {
		vehicleModelService.saveVehicleModel(new VehicleModel(2, "re", (Integer) null, vehicleType.TWO_WHEELER));
	}

	/* finding vehiclemodel by unknown id */
	@Test(expected = NullPointerException.class)
	public void testFindVehicleModelByUnknownId() {
		VehicleModel vehicleModelFoundByUnknownId = vehicleModelService.findVehicleModelById(9);
		assertEquals(null, vehicleModelFoundByUnknownId.getId());
	}

	@AfterClass
	public static void tearDown() {
		vehicleModel = null;
	}

}

package com.rentals.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.rentals.model.VehicleModel;
import com.rentals.repository.VehicleModelRepository;

@Service
@Transactional
public class VehicleModelService {

	private static final Logger logger = LoggerFactory.getLogger(VehicleModelService.class);

	private final VehicleModelRepository vehicleModelRepository;

	public VehicleModelService(VehicleModelRepository vehicleModelRepository) {
		this.vehicleModelRepository = vehicleModelRepository;
	}

	public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
		try {
			vehicleModel.setVehicleType(vehicleModel.getVehicleType());
			vehicleModelRepository.save(vehicleModel);
		} catch (Exception ex) {
			logger.error("Error in saving vehicle model !!!", ex);
		}

		return vehicleModel;
	}

	public List<VehicleModel> findAllvehicleModel() {
		List<VehicleModel> listOfVehicleModel = new ArrayList<VehicleModel>();
		for (VehicleModel vehicleModel : vehicleModelRepository.findAll()) {
			listOfVehicleModel.add(vehicleModel);
		}
		return listOfVehicleModel;
	}

	public VehicleModel findVehicleModelById(int id) {
		return vehicleModelRepository.findOne(id);
	}

	public void deleteVehicleModel(VehicleModel vehicleModel) {
		vehicleModelRepository.delete(vehicleModel);
	}
}

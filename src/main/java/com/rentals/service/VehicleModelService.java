package com.rentals.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.rentals.model.VehicleModel;
import com.rentals.model.VehicleType;
import com.rentals.repository.VehicleModelRepository;

@Service
@Transactional
public class VehicleModelService {

	private final VehicleModelRepository vehicleModelRepository;

	public VehicleModelService(VehicleModelRepository vehicleModelRepository) {
		this.vehicleModelRepository = vehicleModelRepository;
	}

	public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
		//vehicleModel.setVehicleType(vehicleType);
		vehicleModel.setVehicleType(vehicleModel.getVehicleType());
		vehicleModelRepository.save(vehicleModel);
		return vehicleModel;
	}

	public List<VehicleModel> findAllvehicleModel() {
		List<VehicleModel> vehicleModels = new ArrayList<VehicleModel>();
		for (VehicleModel vehicleModel : vehicleModelRepository.findAll()) {
			vehicleModels.add(vehicleModel);
		}
		return vehicleModels;
	}

	public VehicleModel findVehicleModelById(int id) {
		return vehicleModelRepository.findOne(id);
	}

	public void deleteVehicleModel(VehicleModel vehicleModel) {
		vehicleModelRepository.delete(vehicleModel);
	}
}

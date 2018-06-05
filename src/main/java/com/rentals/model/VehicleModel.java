package com.rentals.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class VehicleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	private int modelId;
	@NotBlank
	private String name;
	@Column(nullable = false)
	private int pricePerHour;
	//@Convert(converter = VehicleTypeConverter.class)
    @Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	public VehicleModel() {
	}

	public VehicleModel(int modelId, String name, int pricePerHour,VehicleType vehicleType) {
		super();
		this.modelId = modelId;
		this.name = name;
		this.pricePerHour = pricePerHour;
		this.vehicleType=vehicleType;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(int pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "VehicleModel [modelId=" + modelId + ", name=" + name + ", pricePerHour=" + pricePerHour
				+ ", vehicleType=" + vehicleType + "]";
	}


}

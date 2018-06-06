package com.rentals.model;

import javax.persistence.Column;
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
	private int id;
	@NotBlank
	private String name;
	@Column(nullable = false)
	private int pricePerHour;
	// @Convert(converter = VehicleTypeConverter.class)
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	public VehicleModel() {
	}

	public VehicleModel(int id, String name, int pricePerHour, VehicleType vehicleType) {
		super();
		this.id = id;
		this.name = name;
		this.pricePerHour = pricePerHour;
		this.vehicleType = vehicleType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "VehicleModel [id=" + id + ", name=" + name + ", pricePerHour=" + pricePerHour + ", vehicleType="
				+ vehicleType + "]";
	}

}

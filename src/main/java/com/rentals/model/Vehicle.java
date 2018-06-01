package com.rentals.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "model_Id")
	private VehicleModel modelName;
	@Column(unique = true)
	private String registrationNumber;
	@Column(unique = true)
	private String chassisNumber;

	public Vehicle() {
	}

	public Vehicle(int vehicleId, VehicleModel modelName, String registrationNumber,
			String chassisNumber) {
		super();
		this.vehicleId = vehicleId;
		this.modelName = modelName;
		this.registrationNumber = registrationNumber;
		this.chassisNumber = chassisNumber;
	}

	public int getId() {
		return vehicleId;
	}

	public void setId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public VehicleModel getModelName() {
		return modelName;
	}

	public void setModelName(VehicleModel modelName) {
		this.modelName = modelName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

}

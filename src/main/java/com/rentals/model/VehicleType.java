package com.rentals.model;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum VehicleType implements Serializable {

	TWO_WHEELER("twowheeler"), FOUR_WHEELER("fourwheeler");

	private String value;

	public String getStatus() {
		return this.name();
	}

	private VehicleType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static VehicleType fromValue(String value) {
		for (VehicleType vehicleType : values()) {
			if (vehicleType.value.equalsIgnoreCase(value)) {
				return vehicleType;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}

	@Override
	public String toString() {
		return value;
	}

}

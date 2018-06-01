package com.rentals.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class VehicleTypeConverter implements AttributeConverter<VehicleType, String>  {
	
	 @Override
	    public String convertToDatabaseColumn(VehicleType vehicleType) {
	        switch (vehicleType) {
	            case TWO_WHEELER:
	                return "TWO";
	            case FOUR_WHEELER:
	                return "FOUR";
	            default:
	                throw new IllegalArgumentException("Unknown" + vehicleType);
	        }
	    }
	 
	    @Override
	    public VehicleType convertToEntityAttribute(String dbData) {
	        switch (dbData) {
	            case "TWO":
	                return VehicleType.TWO_WHEELER;
	            case "FOUR":
	                return VehicleType.FOUR_WHEELER;
	            default:
	                throw new IllegalArgumentException("Unknown" + dbData);
	        }
	    }

}

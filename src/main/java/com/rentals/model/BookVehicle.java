package com.rentals.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class BookVehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicleModel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
   	private VehicleModel vehicleModel;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
   	private Vehicle vehicle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookedDateTime;
    @Column(columnDefinition="BOOLEAN DEFAULT true")
    private boolean isBooked;
    
	public BookVehicle() {}

	public BookVehicle(int id, User user, VehicleModel vehicleModel, Vehicle vehicle, Date bookedDateTime,
			boolean isBooked) {
		super();
		this.id = id;
		this.user = user;
		this.vehicleModel = vehicleModel;
		this.vehicle = vehicle;
		this.bookedDateTime = bookedDateTime;
		this.isBooked = isBooked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getBookedDateTime() {
		return bookedDateTime;
	}

	public void setBookedDateTime(Date bookedDateTime) {
		this.bookedDateTime = bookedDateTime;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	
}

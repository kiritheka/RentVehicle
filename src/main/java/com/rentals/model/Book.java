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
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
   	private VehicleModel vehicleModel;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
   	private Vehicle vehicle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateTime;
    @Column(columnDefinition="BOOLEAN DEFAULT true")
    private boolean isBooked;
    
	public Book() {}

	public Book(int bookingId, User userId, VehicleModel vehicleModel,Vehicle vehicle, Date createDateTime,boolean isBooked) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.vehicleModel = vehicleModel;
		this.vehicle = vehicle;
		this.createDateTime = createDateTime;
		this.isBooked = isBooked;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
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

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}	
	
}

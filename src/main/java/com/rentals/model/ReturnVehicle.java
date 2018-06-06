package com.rentals.model;

import java.util.Date;
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
public class ReturnVehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookVehicle_Id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BookVehicle bookVehicle;
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDateTime;
	private int totalRentalCost;

	public ReturnVehicle() {
	}

	public ReturnVehicle(int id, BookVehicle bookVehicle, Date returnDateTime, int totalRentalCost) {
		super();
		this.id = id;
		this.bookVehicle = bookVehicle;
		this.returnDateTime = returnDateTime;
		this.totalRentalCost = totalRentalCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookVehicle getBookVehicle() {
		return bookVehicle;
	}

	public void setBookVehicle(BookVehicle bookVehicle) {
		this.bookVehicle = bookVehicle;
	}

	public Date getReturnDateTime() {
		return returnDateTime;
	}

	public void setReturnDateTime(Date returnDateTime) {
		this.returnDateTime = returnDateTime;
	}

	public int getTotalRentalCost() {
		return totalRentalCost;
	}

	public void setTotalRentalCost(int totalRentalCost) {
		this.totalRentalCost = totalRentalCost;
	}
}
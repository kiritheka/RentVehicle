package com.rentals.model;

import java.time.LocalDateTime;
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
public class Returning {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int returnId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_Id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
   	private Book bookingIden;
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDateTime;
    private int totalRentalCost;
    
	public Returning() {}

	public Returning(int returnId, Book bookingId, Date returnDateTime, int totalRentalCost) {
		super();
		this.returnId = returnId;
		this.bookingIden = bookingId;
		this.returnDateTime = returnDateTime;
		this.totalRentalCost = totalRentalCost;
	}

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public Book getBookingId() {
		return bookingIden;
	}

	public void setBookingId(Book bookingId) {
		this.bookingIden = bookingId;
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
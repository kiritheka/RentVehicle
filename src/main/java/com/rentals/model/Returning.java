package com.rentals.model;

import java.io.Serializable;
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
public class Returning  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int returnId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_Id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
   	private Book book;
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDateTime;
    private int totalRentalCost;
    
	public Returning() {}

	public Returning(int returnId, Book book, Date returnDateTime, int totalRentalCost) {
		super();
		this.returnId = returnId;
		this.book = book;
		this.returnDateTime = returnDateTime;
		this.totalRentalCost = totalRentalCost;
	}

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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
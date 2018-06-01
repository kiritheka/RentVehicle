package com.rentals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	private int userId;
	@NotBlank
	private String name;
	private String email;
	@Column(unique = true)
	private String proofNumber;
	@Column(unique = true)
	private String phoneNumber;

	public User() {
	}

	public User(int userId, String name, String email, String phoneNumber, String proofNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.proofNumber = proofNumber;
	}

	public int getId() {
		return userId;
	}

	public void setId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProofNumber() {
		return proofNumber;
	}

	public void setProofNumber(String proofNumber) {
		this.proofNumber = proofNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", proofNumber=" + proofNumber
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}

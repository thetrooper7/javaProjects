package com.trooper.mvc.objects;

import java.util.Date;

public class RentMovie {
	
	private static int id;
	private Movie movie;
	private Customer customer;
	private String rentin;
	private String rentout;
	private double rentCost;

	public RentMovie() {
		super();
	}

	public RentMovie(Movie movie, Customer customer, String rentin) {
		super();
		this.id = this.id + 1;
		this.movie = movie;
		this.customer = customer;
		this.rentin = rentin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getRentin() {
		return rentin;
	}

	public void setRentin(String rentin) {
		this.rentin = rentin;
	}

	public String getRentout() {
		return rentout;
	}

	public void setRentout(String rentout) {
		this.rentout = rentout;
	}

	public double getRentCost() {
		return rentCost;
	}

	public void setRentCost(double rentCost) {
		this.rentCost = rentCost;
	}

	@Override
	public String toString() {
		return "id:" + this.id + " \nMovie:" + this.movie.toString() + " \nCustomer:" + this.customer.toString() + " \nDate of Rent:"
				+ this.rentin;
	}
}

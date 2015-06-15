package com.trooper.mvc.objects;

import com.trooper.mvc.enums.RentalType;

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
	private String category;
	private int year;
	private RentalType rentalType;
	private int numOfCopies;

	public Movie() {
		super();
	}

	public Movie(String name, String category, int year,
			RentalType rentalType) {
		super();
		this.name = name;
		this.category = category;
		this.year = year;
		this.rentalType = rentalType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public RentalType getRentalType() {
		return rentalType;
	}

	public void setRentalType(RentalType rentalType) {
		this.rentalType = rentalType;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

	@Override
	public String toString() {
		return " Title:" + this.name + " Category:" + this.category + " Year:"
				+ this.year + " RentalType:" + this.rentalType;
	}

}

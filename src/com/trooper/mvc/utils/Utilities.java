package com.trooper.mvc.utils;


import java.text.DecimalFormat;

public class Utilities {

	public Utilities() {
		super();
	}

	public double calculateRentPrice(double rentRate, int days) {

		DecimalFormat df = new DecimalFormat("#.00");
		//return Double.valueOf(df.format(rentRate + (rentRate * days)));
		return rentRate + (rentRate * days);
	}

}

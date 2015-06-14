package com.trooper.mvc.utils;


public class Utilities {
	
	double calculateRentPrice(double rentRate, int days){
		return rentRate + (rentRate*days);
	}

}

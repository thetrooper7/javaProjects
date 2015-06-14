package com.trooper.mvc.enums;

public enum RentalType {
	Daily(1), TwoDay(2), ThreeDay(3);
	
	private final double value;
	
	public double getValue() {
		return value;
	}

	RentalType(final double value){
		this.value = value;		
	}
	
	public double getPrice(){
		if(this.getValue()==1){
			return 1.5;
		}
		else if (this.getValue()==2){
			return 1.2;
		}
		else
			return 1;
	}
	
}

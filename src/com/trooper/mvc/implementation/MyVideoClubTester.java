package com.trooper.mvc.implementation;

import com.trooper.mvc.enums.RentalType;
import com.trooper.mvc.objects.Customer;
import com.trooper.mvc.objects.Movie;
import com.trooper.mvc.objects.RentMovie;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MyVideoClubTester {

	Scanner keyboard = new Scanner(System.in);
    private HashMap<Integer, Movie> allMovies;
    private HashMap<Integer, Customer> allCustomers;
    private HashMap<Integer, RentMovie> allRentals;
    private int selection;

	public static void main(String[] args) {

		MyVideoClubTester tester = new MyVideoClubTester();
		tester.showMenu();

	}

	void showMenu() {
        allMovies = new HashMap<Integer, Movie>();
        allCustomers = new HashMap<Integer, Customer>();
        allRentals = new HashMap<Integer, RentMovie>();
        selection = -1;
		while (selection != 0) {
			System.out.println("MyVideoClub Menu");
			System.out.println("----------------");
			System.out.println("1. Add Movie");
			System.out.println("2. Add Customer");
			System.out.println("3. List Movies");
			System.out.println("4. List Customers");
			System.out.println("5. Rent Movie");
			System.out.println("6. List Rentals");
			System.out.println("7. Return Movie");
			System.out.println("0. Exit");
			System.out.print("Make a Choice:");
			selection = keyboard.nextInt();

			switch (selection) {
			case 1:
				this.addMovie();
				break;
			case 2:
				this.addCustomer();
				break;
			case 3:
                for (Entry<Integer, Movie> m : allMovies.entrySet()) {
                    System.out.println(m.toString());
				}
				break;
			case 4:
                for (Entry<Integer, Customer> c : allCustomers.entrySet()) {
                    System.out.println(c.toString());
				}
				break;
			case 5:
				this.addRental();
				break;
			case 6:
                for (Entry<Integer, RentMovie> r : allRentals.entrySet()) {
                    System.out.println(r.toString());
				}
				break;
			case 7:
				System.out.println("hi");
				break;
			}
		}
	}

	void addMovie() {
		String name;
		String category;
		int year;
		int rentalSelection;
		RentalType rentalType;
		System.out.print("Movie Title:");
		name = keyboard.next();
		System.out.print("Movie Category:");
		category = keyboard.next();
		System.out.print("Movie Year:");
		year = keyboard.nextInt();
		System.out.print("RentalType(1, 2 or 3):");
		rentalSelection = keyboard.nextInt();
		if (rentalSelection == 1) {
			rentalType = RentalType.Daily;
		} else if (rentalSelection == 2) {
			rentalType = RentalType.TwoDay;
		} else
			rentalType = RentalType.ThreeDay;
		Movie m = new Movie(name, category, year, rentalType);
		System.out.println(m.toString());
        allMovies.put(m.getId(), m);
    }

	void addCustomer() {
		String firstName;
		String lastName;
		String address;
		String phone;
		System.out.print("Customer firstName:");
		firstName = keyboard.next();
		System.out.print("Customer lastName:");
		lastName = keyboard.next();
		System.out.print("Customer address:");
		address = keyboard.next();
		System.out.print("Customer phone:");
		phone = keyboard.next();
		Customer c = new Customer(firstName, lastName, address, phone);
		System.out.println(c.toString());
        allCustomers.put(c.getId(), c);
    }

	void addRental() {
		int movieID;
		int customerID;
        for (Entry<Integer, Movie> m : allMovies.entrySet()) {
            System.out.println(m.toString());
		}
		System.out.print("Choose Movie ID:");
		movieID = keyboard.nextInt();

        for (Entry<Integer, Customer> c : allCustomers.entrySet()) {
            System.out.println(c.toString());
		}
		System.out.print("Choose Customer ID:");
		customerID = keyboard.nextInt();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        RentMovie r = new RentMovie(allMovies.get(movieID),
                allCustomers.get(customerID), dateFormat.format(new Date()));
        System.out.println(r.toString());
        allRentals.put(r.getId(), r);

	}
	
	void removeRental(){
		int rentalID;
        for (Entry<Integer, RentMovie> r : allRentals.entrySet()) {
            System.out.println(r.toString());
		}
		System.out.print("Choose Rental ID:");
		rentalID = keyboard.nextInt();
	}
}

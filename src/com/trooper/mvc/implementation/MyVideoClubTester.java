package com.trooper.mvc.implementation;

import com.trooper.mvc.enums.RentalType;
import com.trooper.mvc.objects.Customer;
import com.trooper.mvc.objects.Movie;
import com.trooper.mvc.objects.RentMovie;
import com.trooper.mvc.utils.Utilities;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MyVideoClubTester {

	Scanner keyboard = new Scanner(System.in);
    private HashMap<Integer, Movie> allMovies = new HashMap<Integer, Movie>();
    private HashMap<Integer, Customer> allCustomers = new HashMap<Integer, Customer>();
    private HashMap<Integer, RentMovie> allRentals = new HashMap<Integer, RentMovie>();
    private int selection;
    private int maxMovieNum;
    private int maxCustomerNum;
    private int maxRentalsNum;

	public static void main(String[] args) {

		MyVideoClubTester tester = new MyVideoClubTester();
        tester.retrieveData();
        tester.maxMovieNum = tester.allMovies.size();
        tester.maxCustomerNum = tester.allCustomers.size();
        tester.maxRentalsNum = tester.allRentals.size();
        tester.showMenu();
        tester.saveData();
    }

	void showMenu() {
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
				this.returnRental();
				break;
			}
		}
	}

    void retrieveData() {
        try {
            FileInputStream fis;
            ObjectInputStream ois;

            File f = new File("movies.ser");
            if (f.exists() && !f.isDirectory()) {
                fis = new FileInputStream("movies.ser");
                ois = new ObjectInputStream(fis);
                allMovies = (HashMap<Integer, Movie>) ois.readObject();
                fis.close();
            }
            f = new File("customers.ser");
            if (f.exists() && !f.isDirectory()) {
                fis = new FileInputStream("customers.ser");
                ois = new ObjectInputStream(fis);
                allCustomers = (HashMap<Integer, Customer>) ois.readObject();
                ois.close();
            }
            f = new File("rentals.ser");
            if (f.exists() && !f.isDirectory()) {
                fis = new FileInputStream("rentals.ser");
                ois = new ObjectInputStream(fis);
                allRentals = (HashMap<Integer, RentMovie>) ois.readObject();
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream("movies.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(allMovies);
            oos.close();
            fos = new FileOutputStream("customers.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(allCustomers);
            oos.close();
            fos = new FileOutputStream("rentals.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(allRentals);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
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
        allMovies.put(++this.maxMovieNum, m);
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
        allCustomers.put(++this.maxCustomerNum, c);
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
        allRentals.put(++this.maxRentalsNum, r);

	}

    void returnRental() {
        int rentalID;
        int daysOfDelay = 0;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Entry<Integer, RentMovie> r : allRentals.entrySet()) {
            System.out.println(r.toString());
		}
		System.out.print("Choose Rental ID:");
		rentalID = keyboard.nextInt();
        RentMovie r = allRentals.get(rentalID);

        Utilities util = new Utilities();

        try {
            long diff = (new Date()).getTime() - dateFormat.parse(r.getRentin()).getTime();
            daysOfDelay = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            daysOfDelay -= r.getMovie().getRentalType().getValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("\nMovie Cost is: " + util.calculateRentPrice(r.getMovie().getRentalType().getPrice(), daysOfDelay) + " Euros\n");
        r.setRentout(dateFormat.format(new Date()));
        r.setRentCost(util.calculateRentPrice(r.getMovie().getRentalType().getPrice(), daysOfDelay));
    }
}

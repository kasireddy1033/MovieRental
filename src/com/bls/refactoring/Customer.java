package com.bls.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList rentals = new ArrayList();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public String getName() {
		return name;
	}

public String statement() { 
	
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		String returnVal = "Rental record for : " + this.getName() + ".....\n";
		
		Iterator iter = rentals.iterator();
		
		while(iter.hasNext()) {
			double thisAmount = 0;
			Rental each = (Rental) iter.next();
			//determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
				case Movie.REGULAR: thisAmount += 100;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 75; 
				break;
				
				case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 150; 
				break;
				
				case Movie.CHILDREN:
				thisAmount += 75;
				if (each.getDaysRented() > 3)
				thisAmount += (each.getDaysRented() - 3) * 75; 
				break;
			}
			
			
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
				frequentRenterPoints ++;
			
			//show figures for this rental
			returnVal += "\t" + each.getMovie().getTitle() + ": " + thisAmount + "\n";
			totalAmount += thisAmount;

		}
		
		//print footer
		returnVal += "Amount owed is: " + totalAmount + "\n";
		returnVal += "You have earned " + frequentRenterPoints + " frequent renter points";

		return returnVal;
	}
}

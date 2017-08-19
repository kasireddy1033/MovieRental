package com.bls.refactoring;

import junit.framework.TestCase;

public class MovieRentalAppTest extends TestCase {

	public void testStatement() {
		Customer customer = new Customer("Kasi");
		Rental rental = new Rental(new Movie("Identity Thief", Movie.REGULAR), 5);
		customer.addRental(rental);
		rental = new Rental(new Movie("Wall E", Movie.CHILDREN), 4);
		customer.addRental(rental);
		rental = new Rental(new Movie("In time", Movie.NEW_RELEASE), 7);
		customer.addRental(rental);
		assertEquals("Rental record for : Kasi.....\n" 
				+ "\tIdentity Thief: 325.0\n" 
				+ "\tWall E: 150.0\n" 
				+ "\tIn time: 1050.0\n"
				+ "Amount owed is: 1525.0\n"
				+ "You have earned 4 frequent renter points", customer.statement());
	}
}

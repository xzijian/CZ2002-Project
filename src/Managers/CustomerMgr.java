package Managers;

import Entities.Customer;
import Entities.Restaurant;
import java.util.Scanner;

/**
 Represents the manager for Customer
 @author Hermes Lim
 @version 1.0
 @since 2021-11-12
 */

public class CustomerMgr {

	/**
	 * Check if a customer exist via their phone number.
	 * Ensure no duplicate.
	 * @param name
	 * @param number
	 * @param member
	 * @return boolean when customer exists in the database
	 */

	public static int checkCustomer(String name, String number, boolean member) {
		int exist = 0;
		if (Restaurant.customersList == null)
			System.out.println("I am empty");
		for (Customer customer : Restaurant.customersList) {
			if (number.equals(customer.getCustomerContact()))
			{
				exist = 1;
				return exist;
			}
		}
		return exist;
	}

	/**
	 * Get customer based on contact number.
	 * @param number
	 * @return customer object
	 */

	public static Customer getCustomer(String number) {
		for (Customer customer :  Restaurant.customersList) {
			if (customer.getCustomerContact().equals(number))
			{
				return customer;
			}

		}
		System.out.println("Customer does not exist");
		return null;
	}

	/**
	 * Remove customer from customer arraylist.
	 * @param number
	 */

	public static void removeCustomer(String number) {
		int i = 0;
		int removeC = 0;
		for (Customer customer : Restaurant.customersList) {
			if (customer.getCustomerContact().equals(number))
			{
				Restaurant.customersList.remove(i);
				System.out.println("Customer: " + customer.getCustomerName() + " is removed from database.");
				removeC = 1;
				break;
			}
			i++;
		}
		if (removeC == 0) {
			System.out.println("Customer not found.");
		}
	}

	/**
	 * Create customer if they are not in the database.
	 * @param number
	 */

	public static void createCustomer(String number) {
		String name;
		boolean membership= false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter customer name:");

		name = sc.next();
		Customer newCustomer = new Customer(name, number, membership);
		Restaurant.customersList.add(newCustomer);
		System.out.println("Customer Added to Database.");
	}

}


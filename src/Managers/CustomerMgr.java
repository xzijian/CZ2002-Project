package Managers;

import Entities.Customer;
import Entities.Restaurant;

public class CustomerMgr {
	
	//check if a customer exist via their phone number. Ensure no duplicate.
	public static int checkCustomer(String name, String number, boolean member) {
		int exist = 0;
		if (Restaurant.customersList == null)
			System.out.println("I am empty");
		for (Customer customer : Restaurant.customersList) {
			if (number.equals(customer.getCustomerContact()))
			{
				System.out.println("Customer exists");
				exist = 1;
				return exist;
			}
		}
		return exist;
	}
	//obtain a customer via their number.
	public static Customer getCustomer(String number) {
		for (Customer customer :  Restaurant.customersList) {
			if (customer.getCustomerContact().equals(number))
			{
				System.out.println("Customer found.");
				return customer;
			}
					
		}
		System.out.println("Customer does not exist");
		return null;		
	}
	//remove customer from the customerArrayList.
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
}

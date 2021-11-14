package Entities;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 Represents the customer that visited the restaurant.
	 @author Hermes Lim
	 @version 1.0
	 @since 2021-11-12
	 */

	/**
	 * This is used during deserialization to verify that the sender and receiver of a serialized object have loaded
	 * classes  for that object that are compatible with respect to serialization.
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * The name of the customer.
	 */

	private String cusName;

	/**
	 * The contact of the customer.
	 */

	private String cusContact;

	/**
	 * This indicates if the customer has a membership.
	 */

	private Boolean cusMembership;

	/**
	 * Creates a dummy customer
	 */

	public Customer() {
		cusName = "NULL";
		cusContact = "NULL";
		cusMembership = false;
	}

	/**
	 * Creates a customer with the given name, contact and indicate if customer has a membership.
	 * @param c_name              Name of customer
	 * @param c_contact           Contact number of customer
	 * @param c_membership        Membership status of customer
	 */

	public Customer(String c_name, String c_contact, Boolean c_membership) {
		cusName = c_name;
		cusContact = c_contact;
		cusMembership = c_membership;
	}

	/**
	 * Get the customer's name.
	 * @return this customer's name
	 */

	public String getCustomerName() {
		return this.cusName;
	}

	/**
	 * Get the customer's contact.
	 * @return this customer's contact
	 */

	public String getCustomerContact() {
		return this.cusContact;
	}

	public String membershipStatus() {
		if (this.cusMembership == true)
			return "Member";
		else
			return "Non-Member";
	}

	/**
	 * Change the customer's name
	 * @param c_name            Name of customer
	 */

	public void setCustomerName(String c_name) {
		this.cusName = c_name;
	}

	/**
	 * Change the customer's contact.
	 * @param cus_contact         Contact number of customer
	 */

	public void setContact(String cus_contact) {
		this.cusContact = cus_contact;
	}

	/**
	 * Set this customer's membership status to valid.
	 */

	public void setMembership() {
		this.cusMembership = true;
	}

	/**
	 * Remove this customer's membership status.
	 */

	public void cancelMembership() {
		this.cusMembership = false;
	}

	/**
	 * Get the customer's membership status.
	 * @return this customer's membership status.
	 */

	public boolean getMembership(){ return this.cusMembership;}
}

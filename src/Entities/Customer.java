package Entities;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cusName;
	private String cusContact;
	private Boolean cusMembership;
	
	public Customer() {
		cusName = "NULL";
		cusContact = "NULL";
		cusMembership = false;
	}
	
	
	public Customer(String c_name, String c_contact, Boolean c_membership) {
		cusName = c_name;
		cusContact = c_contact;
		cusMembership = c_membership;
	}
	
	public String getCustomerName() {
		return this.cusName;
	}
	
	public String getCustomerContact() {
		return this.cusContact;
	}
	
	public String membershipStatus() {
		if (this.cusMembership == true)
			return "Member";
		else 
			return "Non-Member";
	}
	
	public void setCustomerName(String c_name) {
		this.cusName = c_name;
	}
	
	public void setContact(String cus_contact) {
		this.cusContact = cus_contact;
	}
	
	public void setMembership() {
		this.cusMembership = true;
	}
	
	public void cancelMembership() {
		this.cusMembership = false;
	}

	public boolean getMembership(){ return this.cusMembership;}
}

public class Customer {
	String cusName;
	String cusContact;
	Boolean cusMembership;
	
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
	/*
	public void createCustomerDB() {
		try {
			File myObj = new File("customerDB.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
			}
		} catch (IOException e) {
			System.out.println("An Error occured.");
			e.printStackTrace();
		}
	}
	public void updateCustomerDB(Customer c) {
		try {
			FileWriter myWriter = new FileWriter("customerDB.txt");
			myWriter.write("{\nCustomer Name: " + c.getCustomerName() 
							+ "\nCustomer Contact: " + c.getCustomerContact() 
							+ "\nCustomer Membership: " + c.membershipStatus()
							+"\n}");
			myWriter.close();
			System.out.println("Successfully added to CustomerDB.");
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
	*/
}

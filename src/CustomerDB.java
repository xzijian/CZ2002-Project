import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CustomerDB {
	private static final String filepath= "TextFolder/customerDB.txt";
	
	public void createCustomerDB() {
		try {
			File myObj = new File("TextFolder/customerDB.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}	
		} catch (IOException e) {
			System.out.println("An Error occured.");
			e.printStackTrace();
		}
	}

	
	public void updateCustomerDB(Customer c) throws ClassNotFoundException {
		int lineNumber = 0;
		int exist = 0;
		try {
			FileWriter myWriter = new FileWriter("TextFolder/customerDB.txtt", true);
			if (exist == 0) {
				try {
					File file = new File("TextFolder/customerDB.txt");
					Scanner sc = new Scanner(file);
					
					while(sc.hasNextLine()) {
						String line = sc.nextLine();
						lineNumber++;
						if (line.contains(c.getCustomerContact())) {
							System.out.println("Customer already registered");  
							exist = 1;
						}
					}
				} catch(FileNotFoundException e) {
						System.out.println("An error occured.");
						e.printStackTrace();
					}
			}
			if (exist == 0) {
				myWriter.write(c.getCustomerName() + "-"
						+ c.getCustomerContact() + "-" 
						+ c.membershipStatus() + "\n");
				
				myWriter.close();
				System.out.println("Successfully added to CustomerDB.");
			}
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}

	public ArrayList<Customer> returnArrayListOfCustomer() throws FileNotFoundException {
		ArrayList<Customer> cusArrList = new ArrayList<Customer>();	
		try {
	    	List<String> customerLines = Files.readAllLines(java.nio.file.Paths.get("TextFolder/customerDB.txt"));
	    	
	    	for (String line: customerLines) {
	    		Customer customer = new Customer1();
	    		String[] tokens = line.split("-");
	    		customer.setCustomerName(tokens[0]);
	    		customer.setContact(tokens[1]);
	    		if(tokens[2].toLowerCase() == "member") {
	    			customer.setMembership();
	    		}
	    		else {
	    			customer.cancelMembership();
	    		}
	    		cusArrList.add(customer);
	    	}
	    } catch (IOException e) {
            e.printStackTrace();
	    
	    }	
		return cusArrList;
	}

}

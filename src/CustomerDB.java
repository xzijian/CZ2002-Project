import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class CustomerDB {
	public void createCustomerDB() {
		try {
			File myObj = new File("C:\\Users\\herme\\Dropbox\\My PC (LAPTOP-T0F2VDR7)\\Desktop\\NTUY2S1\\CZ2002\\Project\\proj\\src\\customerDB.txt");
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
	public void updateCustomerDB(Customer c) {
		int lineNumber = 0;
		int exist = 0;
		try {
			FileWriter myWriter = new FileWriter("C:\\\\Users\\\\herme\\\\Dropbox\\\\My PC (LAPTOP-T0F2VDR7)\\\\Desktop\\\\NTUY2S1\\\\CZ2002\\\\Project\\\\proj\\\\src\\\\customerDB.txt", true);
			if (exist == 0) {
				try {
					File file = new File("C:\\\\Users\\\\herme\\\\Dropbox\\\\My PC (LAPTOP-T0F2VDR7)\\\\Desktop\\\\NTUY2S1\\\\CZ2002\\\\Project\\\\proj\\\\src\\\\customerDB.txt");
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
				myWriter.write("\n{\n\tCustomer Name: " + c.getCustomerName() + ","
						+ "\n\tCustomer Contact: " + c.getCustomerContact() + "," 
						+ "\n\tCustomer Membership: " + c.membershipStatus() + ","
							+"\n}");
				myWriter.close();
				System.out.println("Successfully added to CustomerDB.");
			}
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
}




import java.util.Scanner;


public class Test {
	public static void main(String args[]) {
		Restaurant.loadState();
		Scanner sc = new Scanner(System.in);
		int choice;
		 do {
	            System.out.println("\nSelect your desired choice: ");
	            System.out.println("1.Reservation");
	            System.out.println("2.Add Tom");
	            System.out.println("3.Show added employees");
	            System.out.println("4.Remove all added employees");
	            System.out.println("5.Exit");
	            
	            
	        	System.out.println();
	        	
	        	choice = sc.nextInt();
	            
	            switch (choice) {
	                case 1:
	                	ReservationUi.reservationChoice();
	                    break;
	                case 2:
	                	restaurant.Staff tom = new restaurant.Staff("tom", true, 1, "dog");
	                	Restaurant.employeeStaff.add(tom);
	                	break;
	                case 3:
	                	System.out.println("Staff that were added before.");
						for (int i = 0; i < Restaurant.employeeStaff.size(); i ++) {
							System.out.println(Restaurant.employeeStaff.get(i).getStaffName());
						}
	                	
	                	break;
	                case 4:
	                	Restaurant.employeeStaff.clear();
	                	break;
	                	
	                	
	                default:
	                	System.out.println("Invalid choice has been selected. Exiting system..");

	            }

	        } while (choice < 5);
		
		
		Restaurant.saveState();
    	System.exit(0);
	}
}

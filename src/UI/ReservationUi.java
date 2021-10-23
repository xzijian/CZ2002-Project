package restaurant;
import java.util.ArrayList;
import java.util.Scanner;



public class ReservationUi {
	public static void reservationChoice() {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
            System.out.println("\nInput your choice: ");
            System.out.println("1. Walk in");
            System.out.println("2. Available Reservations");
            System.out.println("3. Add Reservation");
            System.out.println("4. Remove Reservation");

        	System.out.println();
        	
        	choice = sc.nextInt();

        	switch(choice) {
        	case 1:
        		break;
        	case 2:
        		break;
        	case 3:
        		break;
        	case 4:
        		break;
        	case 5:
        		break;
        	default:
        		System.out.println("Invalid input please try again.");
        	}
        } while (choice < 6);
	}
}

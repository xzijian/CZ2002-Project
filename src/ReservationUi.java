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
            System.out.println("2. Reservation");
            System.out.println("3. Available Reservations");

        	System.out.println();
        	
        	choice = sc.nextInt();

        	switch(choice) {
        	case 1:
        		break;
        	case 2:
        		break;
        	case 3:
        		break;
        	}
        } while (choice < 4);
	}
}

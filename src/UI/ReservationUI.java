package UI;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import Entities.Tables;
import java.text.SimpleDateFormat;
import java.util.Date;





public class ReservationUI {
	public static void reservationChoice() throws ParseException {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
            System.out.println("\nInput your choice: ");
            System.out.println("1. Add Entities.Reservation");
            System.out.println("2. List Entities.Reservation Availability");

        	System.out.println();
        	
        	choice = sc.nextInt();

        	switch(choice) {
        	case 1:
				createReservationUI();
        		break;
        	case 2:
				listReservationsUI();
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



	public static void createReservationUI() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Phone number: ");
		//get customer

		System.out.print("Number of pax: ");
		int pax = scan.nextInt();
		int tableNum = Tables.getAvailableTable(pax);

		System.out.print("Date (DD/MM/YYYY): ");
		String dateStr = scan.nextLine();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);

		System.out.print("Time (HH:MM): ");
		String timeStr = scan.nextLine();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		Date t = dateFormat.parse(timeStr);



	}

	public static void listReservationsUI() {

	}
}

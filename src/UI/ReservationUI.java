package UI;

import Entities.Customer;
import Entities.Reservation;
import Managers.CustomerMgr;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import Entities.Tables;
import Managers.ReservationMgr;

import java.text.SimpleDateFormat;
import java.util.Date;





public class ReservationUI {
	public static void reservationChoice() throws ParseException {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			ReservationMgr.checkExpiredReservations();
            System.out.println("\nInput your choice: ");
            System.out.println("1. Make Reservation");
            System.out.println("2. List Reservation Availability");

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
				removeReservationUI();
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
		System.out.print("Enter Customer Number: ");
		/*String phone_no = scan.nextLine()
		Customer cust = CustomerMgr.getCustomer(phone_no);
		//get customer ADD CUSTOMER TO DATABASE IF NOT ALREADY IN
		if (cust == null) {
			CustomerMgr.createCustomer(String phone_no);
		}*/
		//if (cust == null) {
		Customer cust = new Customer("Placeholder", "91234567", false);
		//}

		System.out.print("Number of pax: ");
		int pax = scan.nextInt();
		int tableNum = ReservationMgr.getAvailableTable(pax);
		scan.nextLine();

		System.out.print("Date and time DD/MM/YYYY HH:mm : ");
		String dateStr = scan.nextLine();
		Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateStr);


		ReservationMgr.createReservation(date, pax, tableNum, cust);

	}

	public static void listReservationsUI() {
		ReservationMgr.printReservedTables();
	}

	public static void removeReservationUI() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Provide customer's number: ");
		CustomerMgr.getCustomer(scanner.nextLine());


	}
}

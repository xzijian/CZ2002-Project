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
	public static void reservationChoices() throws ParseException {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			ReservationMgr.checkExpiredReservations();
			System.out.println("\n\n");
			System.out.println("\t==Reservation Options==");
            System.out.println("(1) Make Reservation");
            System.out.println("(2) List Reservations");
			System.out.println("(3) Remove Reservation");
			System.out.println("(4) Show Table Availability");
			System.out.println("(5) Back\n");
			System.out.print("Input your choice: ");
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
					showAvailabilityUI();
					break;
				case 5:
        		default:
        			System.out.println("Exiting Reservation UI...");
        	}
        } while (choice < 5);
	}



	public static void createReservationUI() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Customer Number: ");
		String phone_no = scan.nextLine();
		Customer cust = CustomerMgr.getCustomer(phone_no);
		//get customer ADD CUSTOMER TO DATABASE IF NOT ALREADY IN
		if (cust == null) {
			CustomerMgr.createCustomer(phone_no);
			cust = CustomerMgr.getCustomer(phone_no);
		}


		System.out.print("Number of pax: ");
		int pax = scan.nextInt();
		int tableNum = ReservationMgr.getAvailableTable(pax);
		scan.nextLine();

		System.out.print("Date and time DD/MM/YYYY HH:mm : ");
		String dateStr = scan.nextLine();
		Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateStr);


		ReservationMgr.createReservation(date, pax, tableNum, cust);

	}

	public static void listReservationsUI() {ReservationMgr.printArrivedTables();}

	public static void removeReservationUI() {

		ReservationMgr.removeReservation();


	}

	public static void showAvailabilityUI() {
		ReservationMgr.showTableAvailability();
	}
}

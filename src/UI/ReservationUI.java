package UI;

import Entities.Customer;
import Entities.Reservation;
import Managers.CustomerMgr;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Entities.Tables;
import Managers.ReservationMgr;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 Represents the ui displayed when user is accessing the reservation choice.
 @author Xavier Goh
 @version 1.0
 @since 2021-11-12
 */

public class ReservationUI {

	/**
	 * Shows all options user can make which includes
	 * making reservation, list reservation, list availability
	 * and removing reservation.
	 * @throws ParseException
	 */

	public static void reservationChoices() throws ParseException {
		int flag = 1;
		Scanner sc = new Scanner(System.in);
		
		while (flag == 1){
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
        	
        	try {
				int choice = sc.nextInt();
				switch (choice) {
					case 1:
						createReservationUI();
						continue;
					case 2:
						listReservationsUI();
						continue;
					case 3:
						removeReservationUI();
						continue;
					case 4:
						showAvailabilityUI();
						continue;
					case 5:
						System.out.println("Exiting Reservation UI ...");
						flag = 0;
						break;
					default:
						System.out.println("Error! Invalid index entered!");
				}
			}catch (InputMismatchException ex) {
				System.out.println("Error! Invalid input entered!");
				sc.reset();
				sc.next();
			}
        }
	}

	/**
	 * To be entered with customer number
	 * followed by number of pax and the date and time
	 * to create the reservation.
	 * @throws ParseException
	 */

	public static void createReservationUI() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Customer Number: ");
		String phone_no = scan.nextLine();
		Customer cust = CustomerMgr.getCustomer(phone_no);
		if (cust == null) {
			CustomerMgr.createCustomer(phone_no);
			cust = CustomerMgr.getCustomer(phone_no);
		}


		System.out.print("Number of pax: ");
		int pax = scan.nextInt();
		int tableNum = ReservationMgr.getAvailableTable(pax);
		scan.nextLine();
		Date date;
		while (true) {
			System.out.print("Date and time DD/MM/YYYY HH:mm : ");
			String dateStr = scan.nextLine();
			try {
				date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateStr);
				break;
			} catch (ParseException p) {
				System.out.println("Invalid date-time input. Please enter according to the specified format.");
			}
		}
		ReservationMgr.createReservation(date, pax, tableNum, cust);

	}

	/**
	 * Print tables that are reserved.
	 */

	public static void listReservationsUI() {ReservationMgr.printArrivedTables();}

	/**
	 * Displays the option to remove reservation.
	 * User to enter customer's number to verify the cancellation.
	 */

	public static void removeReservationUI() {
		ReservationMgr.removeReservation();
	}
	/**
	 * Displays the option to show availability.
	 */

	public static void showAvailabilityUI() {
		ReservationMgr.showTableAvailability();
	}
}

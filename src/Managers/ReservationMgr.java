package Managers;

import Entities.Order;
import Entities.Customer;
import Entities.Reservation;
import Entities.Restaurant;
import Entities.Tables;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 Represents the reservation manager in the restaurant.
 @author Xavier Goh
 @version 1.0
 @since 2021-11-12
 */

public class ReservationMgr {

    /**
     * Creates the reservation with the given date, pax, table number and customer
     * @param datetime
     * @param pax
     * @param tableNum
     * @param customer
     */

    public static void createReservation(Date datetime , int pax, int tableNum, Customer customer) {
        int flag = 1;
        for (Reservation r : Restaurant.RestaurantTables) {
            if (r == null) {
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Restaurant is at maximum capacity!");
            return;
        }
        Reservation reservation = new Reservation(datetime , pax, tableNum, customer, false);
        ReservationMgr.setReservedTable(reservation);

        System.out.println("Reservation Successful. Current Reservations");
        printReservedTables();
    }

    /**
     * Vacates a reservation after customer paid.
     * @param order
     */

    public static void vacateReservation(Order order){
        for (int i = 0; i < Restaurant.RestaurantTables.size(); i++) {
            Reservation r = Restaurant.RestaurantTables.get(i);
            if (r != null) {
                if (r.getTableNum() == order.getFromReservation().getTableNum()) {
                    Restaurant.RestaurantTables.set(i, null);
                }
            }
        }
    }

    /**
     * Removes reservation.
     */

    public static void removeReservation() {
        Scanner s = new Scanner(System.in);
        System.out.println("Provide customer's number: ");
        Customer cust = CustomerMgr.getCustomer(s.nextLine());
        for (int i = 0; i < Restaurant.RestaurantTables.size(); i++) {
            Reservation r = Restaurant.RestaurantTables.get(i);
            if (r != null) {
                if (r.getCust().equals(cust)) {
                    System.out.println("Remove " + cust.getCustomerName() + "'s reservation for " + r.getReservationDT().toString() + "? (Y/N)");
                    String choice = s.nextLine();
                    if (choice.toUpperCase(Locale.ROOT).equals("Y")) {
                        Restaurant.RestaurantTables.set(i, null);
                        System.out.println("Reservation by " + cust.getCustomerName() + " has been successfully removed.");
                        return;
                    } else {
                        System.out.println("Reservation removal aborted.");
                    }

                }
            }
        }
        System.out.println("Customer does not have any reservation.");
    }

    /**
     * Prints the table that are reserved.
     */

    public static void printReservedTables() {
        for (int i = 0; i < Restaurant.RestaurantTables.size(); i++) {
            if (Restaurant.RestaurantTables.get(i) != null && Restaurant.RestaurantTables.get(i).isArrived() == false) {
                Restaurant.RestaurantTables.get(i).printReservationDetails();
            }
        }
    }

    /**
     * Prints the table where customer arrived.
     */

    public static void printArrivedTables() {
        for (int i = 0; i < Restaurant.RestaurantTables.size(); i++) {
            if (Restaurant.RestaurantTables.get(i) != null) {
                Restaurant.RestaurantTables.get(i).printReservationDetails();
            }
        }
    }

    /**
     * Gets the tables that are available.
     * @param pax
     * @return available tables
     */

    public static int getAvailableTable(int pax) {
        int i;
        if (pax <= 2) {
            i = 0;
        } else if (pax <= 6){
            i = 6;
        } else if (pax <= 10) {
            i = 6 + 3;
        } else {
            return -1;
        }
        for (; i < Restaurant.RestaurantTables.size(); i++) {
            if (Restaurant.RestaurantTables.get(i) == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Change reserve status of the table.
     * @param r
     */

    public static void setReservedTable(Reservation r) {
        Restaurant.RestaurantTables.set(r.getTableNum(), r);
    }

    /**
     * To check if reservation has expired.
     */

    public static void checkExpiredReservations() {
        ZonedDateTime instant = ZonedDateTime.now();
        for (int i = 0; i < Restaurant.RestaurantTables.size(); i++) {
            Reservation r = Restaurant.RestaurantTables.get(i);
            if (r != null && !r.isArrived()) {
            Date reservationTime = r.getReservationDT();
            long diffInMillies = (reservationTime.getTime() - instant.toInstant().toEpochMilli());
            long diffinMinutes = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if (diffinMinutes < -30) {
                System.out.println("Reservation by " + r.getCust().getCustomerName() + " at " + r.getReservationDT().toString() + " has expired.");
                Restaurant.RestaurantTables.set(i, null);
                }
            }
        }
    }

    /**
     * Change status of arrival for the table.
     * @param tableNum
     * @return the reservation which the customer just arrived
     */

    public static Reservation reservationArrived(int tableNum) {
        Restaurant.RestaurantTables.get(tableNum-1).setArrived();
        return Restaurant.RestaurantTables.get(tableNum-1);
    }

    /**
     * Display current table availability.
     * @param
     */

    public static void showTableAvailability() {
        for (int i = 0; i < Restaurant.RestaurantTables.size(); i++) {
            Reservation r = Restaurant.RestaurantTables.get(i);
            if (r == null) {
                System.out.println("Table " + (i + 1) +" is available");
            }
        }
    }



}

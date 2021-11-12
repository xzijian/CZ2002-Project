package Managers;

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

public class ReservationMgr {

    public static void createReservation(Date datetime , int pax, int tableNum, Customer customer) {
        Reservation reservation = new Reservation(datetime , pax, tableNum, customer);
        ReservationMgr.setReservedTable(reservation);

        System.out.println("Reservation Successful. Current Reservations");
        printReservedTables();
    }

    public static void removeReservation(Customer cust) {
        Scanner s = new Scanner(System.in);
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
    }

    public static void printReservedTables() {
        for (int i = 0; i < Restaurant.RestaurantTables.size(); i++) {
            if (Restaurant.RestaurantTables.get(i) != null) {
                Restaurant.RestaurantTables.get(i).printReservationDetails();
            }
        }
    }

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


    public static void setReservedTable(Reservation r) {
        Restaurant.RestaurantTables.set(r.getTableNum(), r);
    }

    public static void checkExpiredReservations() {
        ZonedDateTime instant = ZonedDateTime.now();
        for (int i = 0; i < Restaurant.RestaurantTables.size(); i++) {
            Reservation r = Restaurant.RestaurantTables.get(i);
            if (r == null) {continue;}
            Date reservationTime = r.getReservationDT();
            long diffInMillies = (reservationTime.getTime() - instant.toInstant().toEpochMilli());
            long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if (diff < -30) {
                System.out.println("Reservation by " + r.getCust().getCustomerName() + " at " + r.getReservationDT().toString() + " has expired.");
                Restaurant.RestaurantTables.set(i, null);
            }
        }
    }

}

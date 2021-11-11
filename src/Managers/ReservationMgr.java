package Managers;

import Entities.Customer;
import Entities.Reservation;
import Entities.Tables;

import java.util.Date;

public class ReservationMgr {

    public static void createReservation(Date datetime , int pax, int tableNum, Customer customer) {
        Reservation reservation = new Reservation(datetime , pax, tableNum, customer);
        Tables.setReservedTable(reservation);

        System.out.println("Reservation Successful. Current Reservations");
        Tables.printReservedTables();
    }

    public static void removeReservation(Customer cust) {
        CustomerMgr.getCustomer(""); // GET CUSTOMERS ADDED IN
        Tables.RemoveReservationByCustomer(cust);
    }

}

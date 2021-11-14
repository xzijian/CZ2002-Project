package Entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 Represents the tables in the restaurant.
 @author Xavier Goh
 @version 1.0
 @since 2021-11-12
 */

public class Tables implements Serializable {

    /**
     * Number of 2-seater tables available.
     */

    private int availableTablesOfTwo;

    /**
     * Number of 6-seater tables available.
     */

    private int availableTablesOfSix;

    /**
     * Number of 10-seater tables available.
     */

    private int availableTablesOfTen;

    /**
     * Number of 10-seater tables in the restaurant.
     * Initializing it to 6.
     */

    /**
     * arrayList of reservation.
     */

    private static ArrayList<Reservation> reservedTable;

    /**
     * To indicate if restaurant is full
     */

    private boolean atMaxCapacity;

    /**
     * Creating the tables of two, six and ten with the
     * given values.
     * @param numOfTablesOfTwo          Number of tables that seats two
     * @param numOfTablesOfSix          Number of tables that seats six
     * @param numOfTablesOfTen          Number of tables that seat ten
     */

    public Tables(int numOfTablesOfTwo, int numOfTablesOfSix, int numOfTablesOfTen)
    {
        this.availableTablesOfTwo = numOfTablesOfTwo;
        this.availableTablesOfSix = numOfTablesOfSix;
        this.availableTablesOfTen = numOfTablesOfTen;

        reservedTable = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            reservedTable.add(i, null); // Entities.Tables without reservations are set to null
        }

        this.atMaxCapacity = false;
    }

    /**
     * Get the number of available tables of six.
     * @return this table's number of available table of six
     */

    public int getAvailableTablesOfSix() {
        return availableTablesOfSix;
    }

    /**
     * Get the number of available tables of ten.
     * @return this table's number of available table of ten
     */

    public int getAvailableTablesOfTen() {
        return availableTablesOfTen;
    }

    /**
     * Get the number of available tables of two.
     * @return this table's number of available table of two
     */

    public int getAvailableTablesOfTwo() {
        return availableTablesOfTwo;
    }

    /**
     * Remove the reservation based on the customer
     * @param cust            Customer who made the reservation
     */

    public static void RemoveReservationByCustomer(Customer cust) {
        for (Reservation r : reservedTable) {
            if (r.getCust().equals(cust)) {
                r = null;
                break;
            }
        }
        System.out.println("Reservation successfully removed.\nRemaining Reservations: ");

    }

    /**
     * Gets the tables that are reserved.
     * @return reserved tables
     */

    public  ArrayList<Reservation> getReservedTables() {
        return reservedTable;
    }
}

package Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Tables implements Serializable {
    private int availableTablesOfTwo;
    private int availableTablesOfSix;
    private int availableTablesOfTen;
    private static ArrayList<Reservation> reservedTable;
    private boolean atMaxCapacity;

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

    public int getAvailableTablesOfSix() {
        return availableTablesOfSix;
    }

    public int getAvailableTablesOfTen() {
        return availableTablesOfTen;
    }

    public int getAvailableTablesOfTwo() {
        return availableTablesOfTwo;
    }



    public static void RemoveReservationByCustomer(Customer cust) {
        for (Reservation r : reservedTable) {
            if (r.getCust().equals(cust)) {
                r = null;
                break;
            }
        }
        System.out.println("Reservation successfully removed.\nRemaining Reservations: ");

    }

    public  ArrayList<Reservation> getReservedTables() {
        return reservedTable;
    }


}

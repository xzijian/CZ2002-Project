package Entities;

public class Tables {
    private int availableTablesOfTwo;
    private int availableTablesOfSix;
    private int availableTablesOfTen;
    private int numOfTablesOfTwo;//6
    private int numOfTablesOfSix;//3
    private int numOfTablesOfTen;//2
    private static Reservation[] reservedTable;
    private boolean atMaxCapacity;

    public Tables(int numOfTablesOfTwo, int numOfTablesOfSix, int numOfTablesOfTen)
    {
        this.availableTablesOfTwo = numOfTablesOfTwo;
        this.availableTablesOfSix = numOfTablesOfSix;
        this.availableTablesOfTen = numOfTablesOfTen;

        reservedTable = new Reservation[numOfTablesOfSix + numOfTablesOfTen +numOfTablesOfTwo];

        for (Reservation table: reservedTable) {
            table = null; // Entities.Tables without reservations are set to null
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
        for (; i < reservedTable.length; i++) {
            if (reservedTable[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static void setReservedTable(Reservation r) {
        reservedTable[r.getTableNum()] = r;
    }

    public static void printReservedTables() {
        for (Reservation r : reservedTable) {
            if (r != null) {
                r.printReservationDetails();
            }
        }
    }

    public static void RemoveReservationByCustomer(Customer cust) {
        for (Reservation r : reservedTable) {
            if (r.getCust().equals(cust)) {
                r = null;
                break;
            }
        }
        System.out.println("Reservation successfully removed.\nRemaining Reservations: ");
        printReservedTables();
    }

}

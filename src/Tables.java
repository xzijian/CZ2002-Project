public class Tables {
    private int availableTablesOfTwo;
    private int availableTablesOfSix;
    private int availableTablesOfTen;
    private int numOfTablesOfTwo;//6
    private int numOfTablesOfSix;//3
    private int numOfTablesOfTen;//2
    private Reservation[] reservedTable;
    private boolean atMaxCapacity;

    public Tables(int numOfTablesOfTwo, int numOfTablesOfSix, int numOfTablesOfTen)
    {
        this.availableTablesOfTwo = numOfTablesOfTwo;
        this.availableTablesOfSix = numOfTablesOfSix;
        this.availableTablesOfTen = numOfTablesOfTen;

        this.reservedTable = new Reservation[numOfTablesOfSix + numOfTablesOfTen +numOfTablesOfTwo];

        for (Reservation table: reservedTable) {
            table = null; // Tables without reservations are set to null
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

    public int makeReservation(String dateTime, int pax)
    {
        int i;
        if (pax <= 2) {
            i = 0;
        } else if (pax <= 6) {
            i = numOfTablesOfTwo;
        } else if (pax <= 10) {
            i = numOfTablesOfTwo + numOfTablesOfSix;
        } else {
            return -100; // Too many guests to fit in any table
        }

        for (; i < reservedTable.length; i++) {
            if (reservedTable[i] == null) {
                reservedTable[i] = new Reservation(dateTime, pax, i+1);
                if (i < numOfTablesOfTwo) {
                    numOfTablesOfTwo--;
                } else if (i < numOfTablesOfSix) {
                    numOfTablesOfSix--;
                } else {
                    numOfTablesOfTen--;
                }
                return 1;
            }
        }
        return -1;
    }
}

package Entities;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
    private String datetime;
    private int numOfPax;
    private int tableNum;
    private Customer cust;
    private int reservationID;

    public Reservation(Date date, Date time, int numOfPax, int tableNum, Customer cust) {
        this.datetime = datetime;
        this.cust = cust;
        this.numOfPax = numOfPax;
        this.tableNum = tableNum;
        // generate random reservation id
    }

    public int getTableNum() {
        return this.tableNum;
    }

}

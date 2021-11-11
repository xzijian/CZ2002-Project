package Entities;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
    private Date time;
    private Date datetime;
    private int numOfPax;
    private int tableNum;
    private Customer cust;
    private int reservationID;

    public Reservation(Date datetime, int numOfPax, int tableNum, Customer cust) {
        this.datetime = datetime;
        this.cust = cust;
        this.numOfPax = numOfPax;
        this.tableNum = tableNum;
        // generate random reservation id
    }

    public int getTableNum() {
        return this.tableNum;
    }
    public Customer getCust(){ return this.cust; }

    public void printReservationDetails() {
        System.out.println("Table: " + this.tableNum + " is reserved by " + this.cust.getCustomerName() + " for Date:\n"
                + this.datetime );
    }
}

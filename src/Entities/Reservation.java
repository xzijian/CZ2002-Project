package Entities;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
    private Date datetime;
    private int numOfPax;
    private int tableNum;
    private Customer cust;
    private int reservationID;
    private boolean arrived;

    public Reservation(Date datetime, int numOfPax, int tableNum, Customer cust, boolean arrived) {
        this.datetime = datetime;
        this.cust = cust;
        this.numOfPax = numOfPax;
        this.tableNum = tableNum;
        this.arrived = false;
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

    public Date getReservationDT() {
        return this.datetime;
    }

    public void setArrived() {
        this.arrived = true;
    }

    public boolean isArrived() {
        return this.arrived;
    }
}

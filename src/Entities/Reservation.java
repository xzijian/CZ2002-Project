package Entities;

import java.io.Serializable;
import java.util.Date;

/**
 Represents reservation in the restaurant.
 @author Xavier Goh
 @version 1.0
 @since 2021-11-12
 */

public class Reservation implements Serializable {

    /**
     * The date and time for the reservation.
     */

    private Date datetime;

    /**
     * The number of pax for the reservation.
     */

    private int numOfPax;

    /**
     * The table number to reserve.
     */

    private int tableNum;

    /**
     * The customer for the reservation.
     */

    private Customer cust;

    /**
     * The reservation id.
     */

    private int reservationID;

    /**
     * To determine if customer has arrived for the reservation.
     */

    private boolean arrived;

    /**
     * Creates a reservation with the given datetime,
     * number of pax, table number, customer and the status of arrival.
     * @param datetime           Date Time of the reservation
     * @param numOfPax           Number of people for this reservation
     * @param tableNum           Table number of this reservation
     * @param cust               Customer who made the reservation
     * @param arrived            If the customer have arrived
     */

    public Reservation(Date datetime, int numOfPax, int tableNum, Customer cust, boolean arrived) {
        this.datetime = datetime;
        this.cust = cust;
        this.numOfPax = numOfPax;
        this.tableNum = tableNum;
        this.arrived = false;
    }

    /**
     * Get the table number of the reservation.
     * @return this reservation's table number
     */

    public int getTableNum() {
        return this.tableNum;
    }

    /**
     * Get the customer for the reservation.
     * @return this reservation's customer
     */

    public Customer getCust(){ return this.cust; }

    /**
     * print the reservation details.
     */

    public void printReservationDetails() {
        System.out.println("Table: " + (this.tableNum + 1) + " is reserved by " + this.cust.getCustomerName() + " for Date:\n"
                + this.datetime );
    }

    /**
     * Get the date and time of the reservation.
     * @return this reservation's date and time
     */

    public Date getReservationDT() {
        return this.datetime;
    }

    /**
     * Change the status of arrival for the reservation.
     */

    public void setArrived() {
        this.arrived = true;
    }

    /**
     * Check the status of arrival for the reservation.
     * @return this reservation's arrival status
     */

    public boolean isArrived() {
        return this.arrived;
    }
}

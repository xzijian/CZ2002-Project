package Entities;

import Entities.Invoice;
import Entities.Reservation;
import Managers.MenuMgr;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Entities.Order class represents an order
 * @author Xie Zijian
 * @version 1.0
 * @since 2021-11-10
 */

public class Order implements Serializable {

    /**
     * The staff object.
     */

    private Staff staff;

    /**
     * The reservation object.
     */

    private Reservation reservation;

    /**
     * The arraylist of MenuItems which stores the items ordered.
     */

    private ArrayList<MenuItems> itemOrdered;

    /**
     * The invoice object
     */

    private Invoice invoice;

    /**
     * The date and time when the order is created.
     */

    private Date dateTime;

    /**
     * The orderID that generated for each order.
     */

    private int OrderID;

    /**
     * Creates an order that is tagged with a staff.
     * It is also tagged to a reservation.
     * @param createdBy            Staff who created this order
     * @param fromReservation      Reservation which ordered
     */

    public Order(Staff createdBy, Reservation fromReservation){
        this.itemOrdered = new ArrayList<MenuItems>();
        this.staff = createdBy;
        this.reservation = fromReservation;
        this.dateTime = Calendar.getInstance().getTime();
        this.invoice = null;
        this.OrderID = Calendar.getInstance().hashCode();
    }

    /**
     * Get the invoice in Order.
     * @return this invoice
     */

    public Invoice getInvoice() {return this.invoice;}

    /**
     * Get the reservation that is tagged to the order.
     * @return this reservation.
     */

    public Reservation getFromReservation(){return this.reservation;}

    /**
     * Get the date and time tagged to the order.
     * @return this order's date and time
     */

    public Date getDateTime() {return dateTime;}

    /**
     * Get the ID of the order.
     * @return this order's ID
     */

    public int getOrderID(){ return this.OrderID; }

    /**
     * Get the order items in the order.
     * @return this order's itemOrdered
     */

    public ArrayList<MenuItems> getOrderItems(){return this.itemOrdered;}

    /**
     * This initializes for the prompt to add menu items to the order.
     */

    public void orderItems(){
        if(this.invoice != null) return;
        MenuMgr.addMenuItems(this.itemOrdered);
    }

    /**
     * This initializes for the prompt to remove menu items from order.
     */

    public void removeItems(){
        if(this.invoice != null) return;
        MenuMgr.removeMenuItems(this.itemOrdered);
    }

    /**
     * Creates the invoice for the order.
     */

    public void createInvoice(){
        if(this.invoice != null) return;
        this.invoice = new Invoice(this);
    }

    /**
     * Gets the total price of orderedItems.
     * @return this order's price
     */

    public double calculatePrice(){
        double price = 0;
        for(MenuItems o : this.itemOrdered)
            price += o.getPrice();
        return price;
    }

}

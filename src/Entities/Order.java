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
 * @author xie zijian
 * @version 1.0
 * @since 2021-11-10
 */

public class Order implements Serializable {
    private Staff staff;
    private Reservation reservation;
    private ArrayList<MenuItems> itemOrdered;
    private Invoice invoice;
    private Date dateTime;
    private int OrderID;

    public Order(Staff createdBy, Reservation fromReservation){
        this.itemOrdered = new ArrayList<MenuItems>();
        this.staff = createdBy;
        this.reservation = fromReservation;
        this.dateTime = Calendar.getInstance().getTime();
        this.invoice = null;
        this.OrderID = Calendar.getInstance().hashCode();
    }

    public Invoice getInvoice() {return this.invoice;}
    public Reservation getFromReservation(){return this.reservation;}
    public Date getDateTime() {return dateTime;}
    public int getOrderID(){ return this.OrderID; }
    public ArrayList<MenuItems> getOrderItems(){return this.itemOrdered;}

    public void orderItems(){
        if(this.invoice != null) return;
        MenuMgr.addMenuItems(this.itemOrdered);
    }

    public void removeItems(){
        if(this.invoice != null) return;
        MenuMgr.removeMenuItems(this.itemOrdered);
    }

    public void createInvoice(){
        if(this.invoice != null) return;
        this.invoice = new Invoice(this);
    }

    public double calculatePrice(){
        double price = 0;
        for(MenuItems o : this.itemOrdered)
            price += o.getPrice();
        return price;
    }

}

package Entities;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Entities.Invoice class represents an invoice
 * @author xie zijian
 * @version 1.0
 * @since 2021-11-10
 */

public class Invoice implements Serializable {
    private Order order;
    private double price;
    private double gst;
    private double totalPrice;
    private Calendar date;
    private int invoiceNumber;
    private Customer cust;

    public Invoice(Order order){
        this.order = order;
        this.date = Calendar.getInstance();
        this.invoiceNumber = Calendar.getInstance().hashCode();
        this.price = order.calculatePrice();
        this.gst = Math.round(0.07 * this.price * 100.0)/100.0;
        this.cust = this.order.getFromReservation().getCust();
        if (cust.getMembership()) {
            this.totalPrice = (0.9)*(price + gst);
        }
        else this.totalPrice = this.price + this.gst;
    }
    public int getInvoiceNumber(){ return this.invoiceNumber; }
    public Calendar getDate(){ return this.date; }
    public double getTotalPrice(){ return this.totalPrice; }
    public Order getOrder(){ return this.order; }

    public void printInvoice(){
        System.out.println("Date & Time: " + this.order.getDateTime());
        System.out.println("Entities.Invoice Number: " + this.invoiceNumber);
        System.out.println("Items ordered: " + this.order);
        System.out.println("Subtotal: " + price);
        System.out.println("GST: " + gst);
        System.out.println("Total: " + totalPrice);
    }
}


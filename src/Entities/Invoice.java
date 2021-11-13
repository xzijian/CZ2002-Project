package Entities;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Entities.Invoice class represents an invoice
 * @author Xie Zijian
 * @version 1.0
 * @since 2021-11-10
 */

public class Invoice implements Serializable {

    /**
     * Order object.
     */

    private Order order;

    /**
     * The price of the order
     */

    private double price;

    /**
     * The tax that is charged on each order.
     */

    private double gst;

    /**
     * The total price of order including gst and membership validity.
     */

    private double totalPrice;

    /**
     * The date when the invoice is created.
     */

    private Calendar date;

    /**
     * The invoice number tagged to each invoice.
     */

    private int invoiceNumber;

    /**
     * The customer object.
     */

    private Customer cust;

    /**
     * This creates the invoice for an order with given date, generated invoice number, price of order
     * gst included and customer from order with the total price of the order including gst and membership status.
     * @param order
     */

    public Invoice(Order order){
        this.order = order;
        this.date = Calendar.getInstance();
        this.invoiceNumber = Calendar.getInstance().hashCode();
        this.price = order.calculatePrice();
        this.gst = Math.round(0.07 * this.price * 100.0)/100.0;
        this.cust = this.order.getFromReservation().getCust();
        if (cust.getMembership()) {
            this.totalPrice = (0.85)*(price + gst);
        }
        else this.totalPrice = this.price + this.gst;
    }

    /**
     * Get the invoice number
     * @return this invoice's invoice number
     */

    public int getInvoiceNumber(){ return this.invoiceNumber; }

    /**
     * Get the current date.
     * @return this date
     */

    public Calendar getDate(){ return this.date; }

    /**
     * Get the total price of order including gst and membership status.
     * @return this total price.
     */

    public double getTotalPrice(){ return this.totalPrice; }

    /**
     * Get the order object.
     * @return this order
     */

    public Order getOrder(){ return this.order; }

    /**
     * This prints out the invoice.
     */

    public void printInvoice(){
        System.out.println("Date & Time: " + this.order.getDateTime());
        System.out.println("Invoice Number: " + this.invoiceNumber);
        System.out.println("Items ordered: ");
        for (MenuItems mi : this.order.getOrderItems()){
            System.out.println(mi.getName());
        }
        System.out.println("Subtotal: " + price);
        System.out.println("GST: " + gst);
        System.out.println("Total: " + totalPrice);
    }
}


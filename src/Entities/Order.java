package Entities;

import Entities.Invoice;
import Entities.Reservation;

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
    private ArrayList<OrderItems> itemOrdered;
    private Invoice invoice;
    private Date dateTime;
    private int OrderID;

    public Order(Staff createdBy, Reservation fromReservation){
        this.itemOrdered = new ArrayList<OrderItems>();
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
    public ArrayList<OrderItems> getOrderItems(){return this.itemOrdered;}

    public void orderItems(){
        if(this.invoice != null) return;
        int choice;
        int index = 0;
        OrderItems itemOrdering;

        Scanner sc = new Scanner(System.in);
        ArrayList<MenuItems> foodMenu = Restaurant.foodMenu;
        System.out.println("\nSelect the menu item to add:");
        for(MenuItems menuItem : foodMenu) System.out.println("(" + index++ + ") " + menuItem.getName());
        System.out.print("Enter your choice : ");
        choice = sc.nextInt();

        try{
            String orderItemAdded = foodMenu.get(choice).getName();
            itemOrdering = new OrderItems((foodMenu.get(choice)));
            this.itemOrdered.add(itemOrdering);
            System.out.println(orderItemAdded + " added to order.");
        }catch(IndexOutOfBoundsException e){
            System.out.println("Error! Invalid index entered!");
        }
    }

    public void removeItems(){
        if(this.invoice != null) return;
        int choice;
        int index = 0;

        Scanner sc = new Scanner(System.in);
        for (OrderItems orderItems : itemOrdered)
            System.out.println(index++ + ": " + orderItems.getMenuItem().getName());
        System.out.println("Enter your choice : ");
        choice = sc.nextInt();
        try{
            this.itemOrdered.remove(choice);
            System.out.println("Item removed from order.");
            }catch(IndexOutOfBoundsException e){
                System.out.println("Invalid index provided");
        }
    }

    public void createInvoice(){
        if(this.invoice != null) return;
        this.invoice = new Invoice(this);
        //this.reservation.getReserveTable().setStatus(TableStatus.VACATED);
    }

    public double calculatePrice(){
        double price = 0;
        for(OrderItems o : this.itemOrdered)
            price += o.getMenuItem().getPrice();
        return price;
    }

}

package Managers;

import Entities.MenuItems;
import Entities.Order;
import Entities.Invoice;

import java.util.ArrayList;
import java.util.Scanner;
import Entities.Restaurant;

/**
 Represents the order manager in restaurant
 @author Xie Zijian
 @version 1.0
 @since 2021-11-12
 */

public class OrderMgr {

    /**
     * The arrayList of orders.
     */

    private static ArrayList<Order> orders = Restaurant.orders;

    /**
     * The arrayList of completed orders.
     */

    private static ArrayList<Order> completedOrders = Restaurant.completedOrders;

    /**
     * Shows all options user can make which includes
     * showing order details, add order items,
     * remove order items and print invoice.
     */

    public static void menuShowOrder(Order order){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nSelect a choice: ");
            System.out.println("(1) Show order details");
            System.out.println("(2) Add order items");
            System.out.println("(3) Remove order item");
            System.out.println("(4) Print invoice");
            System.out.println("(5) Back");
            System.out.println();
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    orderDetails(order);
                    break;
                case 2:
                    takeOrder(order);
                    break;
                case 3:
                    removeOrderItem(order);
                    break;
                case 4:
                    printInvoice(order);
                    break;
                case 5:
            }
        } while (choice < 4);
    }

    /**
     * Display the items ordered in this order.
     */

    public static void orderDetails(Order order){
        if (order.getOrderItems().size() == 0) System.out.println("No order items in order");
        else {
            int index = 0;
            for (MenuItems mi : order.getOrderItems()){
                System.out.println("(" + index++ +")" + mi.getName());
            }
        }
    }


    /**
     * Create new order for reservation.
     */

    public static void takeOrder(Order order){
        char choice;
        Scanner sc = new Scanner(System.in);
        do{
            order.orderItems();
            System.out.println("Continue ordering? Y/N :");
            choice = sc.nextLine().charAt(0);
        } while (choice == 'Y');
    }

    /**
     * Remove menu items from order.
     */

    public static void removeOrderItem(Order order){
        order.removeItems();
    }

    public static void printInvoice(Order order){
        if(order.getInvoice()==null){
            order.createInvoice();
            Restaurant.invoices.add(order.getInvoice());
            completeOrder(order);
            ReservationMgr.vacateReservation(order);
            order.getInvoice().printInvoice();
        }
    }

    /**
     * Completes an order and move it to the completed order arrayList.
     */

    public static void completeOrder(Order order){
        completedOrders.add(order);
        orders.remove(order);
    }
}

package Managers;

import Entities.MenuItems;
import Entities.Order;
import Entities.Invoice;

import java.util.ArrayList;
import java.util.Scanner;
import Entities.Restaurant;

/**
 * UI.OrderUI class represents an order
 * @author xie zijian
 * @version 1.0
 * @since 2021-11-10
 */

public class OrderMgr {
    private static ArrayList<Order> orders = Restaurant.orders;
    private static ArrayList<Order> completedOrders = Restaurant.completedOrders;
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
    public static void orderDetails(Order order){
        if (order.getOrderItems().size() == 0) System.out.println("No order items in order");
        else {
            int index = 0;
            for (MenuItems mi : order.getOrderItems()){
                System.out.println("(" + index++ +")" + mi.getName());
            }
        }
    }

    public static void takeOrder(Order order){
        char choice;
        Scanner sc = new Scanner(System.in);
        do{
            order.orderItems();
            System.out.println("Continue ordering? Y/N :");
            choice = sc.nextLine().charAt(0);
        } while (choice == 'Y');
    }

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

    public static void completeOrder(Order order){
        completedOrders.add(order);
        orders.remove(order);
    }
}

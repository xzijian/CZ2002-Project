package Managers;

import Entities.Order;
import Entities.Restaurant;
import UI.OrderUI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Entities.Order Manager class allowing user to select an order to edit
 * @author xie zijian
 * @version 1.0
 * @since 2021-11-10
 */
public class OrderMgr {

    private static ArrayList<Order> orders = Restaurant.orders;
    private static ArrayList<Order> completedOrders = Restaurant.completedOrders;

    public static void CompleteOrder(Order order){
        completedOrders.add(order);
        orders.remove(order);
    }

    /**
     * Allow user to select an order
     */
    public static void editPendingOrder(){
        Scanner sc = new Scanner(System.in);
        if(orders.size() == 0){
            System.out.println("No orders available to edit!");
            return;
        }
        int index = 0;
        Order order;
        System.out.println("\nSelect an order.");
        for(Order order1 : orders){
            System.out.println("(" + index++ + ") OrderID: " + order1.getOrderID() + "    TableID: " + order1.getFromReservation().getTableNum());
        }
        System.out.println("Enter the number of your choice: ");
        int choice = sc.nextInt();

        try {
            order = orders.get(choice);
            OrderUI.menuShowOrder(order);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Invalid index entered!");
        }

    }

}

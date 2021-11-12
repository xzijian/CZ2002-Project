package UI;

import Entities.Order;
import Entities.Reservation;
import Entities.Restaurant;
import Managers.OrderMgr;
import Managers.ReservationMgr;
import Entities.Staff;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Entities.Order Manager class allowing user to select an order to edit
 * @author xie zijian
 * @version 1.0
 * @since 2021-11-10
 */
public class OrderUI {

    private static ArrayList<Order> orders = Restaurant.orders;
    private static Scanner sc = new Scanner(System.in);

    public static void PendingOrder(Staff currentStaff){
        int choice;
        do {
            System.out.println("\nSelect a choice: ");
            System.out.println("(1) Take a new order");
            System.out.println("(2) Edit Order");
            System.out.println("(3) Print invoice");
            System.out.println("(4) Back");
            System.out.println();
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    takeOrder(currentStaff);
                    break;
                case 2:
                    editPendingOrder();
                    break;
                case 3:
            }
        } while (choice < 3);
    }

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
            OrderMgr.menuShowOrder(order);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Invalid index entered!");
        }

    }

    public static void takeOrder(Staff currentStaff){
        int choice = 0;
        ReservationMgr.printReservedTables();
        System.out.println("Enter the table number of your choice: ");
        choice = sc.nextInt();
        Reservation thisRV = ReservationMgr.reservationArrived(choice);
        Order newOrder = new Order(currentStaff, thisRV);
        orders.add(newOrder);
        OrderMgr.menuShowOrder(newOrder);
    }

}

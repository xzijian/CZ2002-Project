import java.util.ArrayList;
import java.util.Scanner;

/**
 * Order Manager class allowing user to select an order to edit
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
        for(Order o : orders){
            System.out.println("(" + index++ + ") OrderID: " + o.getOrderID() + "    TableID: " + o.getFromReservation().gettableNum());
        }
        System.out.println("Enter the number of your choice: ");
        int choice = sc.nextInt();

        try {
            order = orders.get(choice);
            //OrderUI.menuShowOrderOptions(order);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Invalid index entered!");
        }

    }

}

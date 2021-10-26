import java.awt.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Order {
    private Staff staff;
    private Reservation reservation;
    private ArrayList<orderItems> itemOrdered;
    private Invoice invoice;
    private Date dateTime;

    public Order(Staff createdBy, Reservation fromReservation){
        this.itemOrdered = new ArrayList<orderItems>();
        this.staff = createdBy;
        this.reservation = fromReservation;
        this.dateTime = Calendar.getInstance().getTime();
        this.invoice = null;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    public Invoice getInvoice(Invoice invoice) {return this.invoice;}
    public Reservation getFromReservation(){
        return this.reservation;
    }
    public Date getDateTime() {return dateTime;}

    public void OrderItems(){
        if(this.invoice != null) return;
        int choice;
        int index = 0;
        orderItems itemOrdering;

        Scanner sc = new Scanner(System.in);
        ArrayList<MenuItems> foodMenu = Restaurant.foodMenu;
        System.out.println("\nSelect the food item to add to the order:");
        for(MenuItems menuItem : foodMenu) System.out.println("(" + index++ + ") " + menuItem.getName());
        System.out.print("Enter your choice : ");
        choice = sc.nextInt();

        try{
            String orderItemAdded = foodMenu.get(choice).getName();
            itemOrdering = new orderItems((foodMenu.get(choice)));
            this.itemOrdered.add(itemOrdering);
            System.out.println(orderItemAdded + " added to order.");
        }catch(IndexOutOfBoundsException e){
            System.out.println("Add order item failed! (Invalid index provided)");
        }
    }


}

import Entities.Restaurant;
import Entities.Staff;
import Managers.InvoiceMgr;
import UI.MenuUI;
import UI.OrderUI;
import Managers.MenuMgr;
import UI.ReservationUI;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application class to start up the application.
 * Provides an interface fo restaurant staff to perform
 * reservation, order and manage restaurant backend.
 * @author Chee Zi Hoe
 * @version 1.0
 * @since 2021-11-12
 */

public class Application {

    /**
     * Set current staff to null to signify no login yet.
     */

    private static Staff current_staff = null;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        Restaurant.loadState();//load restaurant data
        while (current_staff == null)
            current_staff = login(Restaurant.employeeStaff);
        showOptions();

        Restaurant.saveState();
        System.exit(0);
    }

    /**
     * To display the options the user can assess
     * from the start including accessing reservations
     * and orders. Viewing or editing Menu. Printing
     * Sales Revenue Report.
     * @throws ParseException
     */

    public static void showOptions() throws ParseException {
        int flag  = 1;
        while (flag == 1) {
            System.out.println("\t==STAFF INTERFACE==");
            System.out.println("(1) Access Reservations");
            System.out.println("(2) Access Orders");
            System.out.println("(3) View Menu");
            System.out.println("(4) Edit Menu");
            System.out.println("(5) Print Sales Revenue");
            System.out.println("(6) Logout");
            System.out.print("Enter option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ReservationUI.reservationChoices();
                    continue;
                case 2:
                    OrderUI.orderChoices(current_staff);
                    continue;
                case 3:
                    viewMenu();
                    continue;
                case 4:
                    MenuUI.MenuUIOptions();
                    continue;
                case 5:
                    InvoiceMgr.printSalesRevenue();
                    continue;
                case 6:
                    flag = 0;
                    break;
            }
        }
    }

    /**
     * For user to login to their respective accounts.
     * @param staffs
     * @return Current Staff using
     */

    public static Staff login(ArrayList<Staff> staffs){
        int index = 0;
        for(Staff s : staffs){
            System.out.println("(" + index++ + ") Employee Name: "  + s.getStaffName());
        }
        System.out.print("Enter Employee ID: ");
        int choice = sc.nextInt();
        Staff thisStaff = staffs.get(choice);
        return thisStaff;
    }

    /**
     * To display the current menu.
     */

    private static void viewMenu(){
        Scanner sc1 = new Scanner(System.in);
        int choice;
        do {
            MenuMgr.printCategories();
            choice = sc1.nextInt();
            switch (choice){
                case 1:
                    MenuMgr.printDrinks();
                    System.out.print("Enter 1 to back: ");
                    choice = sc.nextInt();
                    break;
                case 2:
                    MenuMgr.printDesserts();
                    System.out.print("Enter 1 to back: ");
                    choice = sc.nextInt();
                    break;
                case 3:
                    MenuMgr.printMains();
                    System.out.print("Enter 1 to back: ");
                    choice = sc.nextInt();
                    break;
                case 4:
                    MenuMgr.printSets();
                    System.out.print("Enter 5 to exit: ");
                    choice = sc.nextInt();
                    break;
                default:
                    System.out.println("Exiting Menu...");
            }
        } while(choice <5);
    }

}
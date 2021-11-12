import Entities.Restaurant;
import Entities.Staff;
import Entities.Tables;
import UI.MenuUI;
import UI.ReservationUI;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.Scanner;

public class Application {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        Restaurant.loadState();//load restaurant data
        //login
        System.out.println(Restaurant.RestaurantTables);
        showOptions();



        Restaurant.saveState();
        System.exit(0);
    }

    public static void showOptions() throws ParseException {
        int choice;
        do {
            System.out.println("\t==STAFF INTERFACE==");
            System.out.println("1.Access Reservations");
            System.out.println("2.Update Orders");
            System.out.println("3.Edit Menu");
            //System.out.println("4.Logout");
            System.out.println("4.Add tom");
            System.out.println("5.Show added employees");
            System.out.println("6.Remove all added employees");
            System.out.println("7.Exit");
            System.out.print("Enter option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ReservationUI.reservationChoice();
                    continue;
                case 2:
                    continue;
                case 3:
                    MenuUI.MenuUIOptions();
                    continue;
                    // case 4:
                    // break;
                case 4:
                    Staff tom = new Staff("tom", true, 1, "dog");
                    Restaurant.employeeStaff.add(tom);
                    break;
                case 5:
                    System.out.println("Staff that were added before.");
                    int i = 0;
                    for(i=0; i<Restaurant.employeeStaff.size();i++) {
                        System.out.println(Restaurant.employeeStaff.get(i).getStaffName());
                    }

                    break;
                case 6:
                    Restaurant.employeeStaff.clear();
                    break;
                default:
                    System.out.println("Invalid choice has been selected. Exiting system..");

            }
        }while (choice < 7);
    }

    public void login() { //return staff instead of void
        System.out.println("\t\t\tBrielle's Bistro Staff Interface\n");
        System.out.print("Enter EmployeeID: ");
        String empID = sc.nextLine();

        // parse employee ARRAYLIST and set employee
        // logic for failed verification
        System.out.println("Logged in as: Xavier");
    }

}
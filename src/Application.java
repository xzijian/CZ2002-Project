

import UI.MenuUI;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {

    private restaurant.Staff current_staff = null;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //load restaurant data
        //login
        showOptions();

        }

    public static void showOptions() {
        while (true) {
            System.out.println("\t==STAFF INTERFACE==");
            System.out.println("1.Access Reservations");
            System.out.println("2.Update Orders");
            System.out.println("3.Edit Menu");
            System.out.println("4.Logout");
            System.out.print("Enter option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    continue;
                case 2:
                    continue;
                case 3:
                    MenuUI.MenuUIOptions();
                    continue;
                case 4:
                    break;
            }
        }
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




package UI;

import java.util.Scanner;

public class MenuUI {
    private static Scanner sc = new Scanner(System.in);

    public static void MenuUIOptions() {
        System.out.println("\n\n");
        System.out.println("\t==Menu Options==");
        System.out.println("1. Create new menu item");
        System.out.println("2. Create new Set Package");
        System.out.println("3. Edit menu item");
        System.out.println("4. Edit Set Package");
        System.out.println("5. Remove menu item");
        System.out.println("6. Remove Set Package\n");

        System.out.print("Enter option: ");
        int choice;
        do {
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //create menuitem
                    break;
                case 2:
                    //create set package
                    break;
                case 3:
                    //edit menu item
                    break;
                case 4:
                    //edit set package
                    break;
                case 5:
                    //remove menu item
                    break;
                case 6:
                    //remove set package
                    break;
                default:
                    System.out.println("Invalid input! Choose 1-6");
            }
        } while ( choice < 1 || choice > 6);

    }
}

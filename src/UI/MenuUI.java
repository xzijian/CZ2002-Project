package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.*;

public class MenuUI {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<MenuItems> menu = Restaurant.foodMenu;
    public static void MenuUIOptions() {
        System.out.println("\n\n");
        System.out.println("\t==Menu Options==");
        System.out.println("1. Create new menu item");
        System.out.println("2. Create new Set Package");
        System.out.println("3. Edit menu");
        System.out.println("4. Remove menu entry");
        System.out.println("5. Back\n");

        System.out.print("Enter option: ");
        int choice;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createMenu();
                    break;
                case 2:
                    createSet();
                    break;
                case 3:
                    editMenu();
                    break;
                case 4:
                    deleteMenu();
                    break;
                default:
                    System.out.println("Invalid input! Choose 1-6");
            }
        } while ( choice < 1 || choice > 6);
    }
    private static void createMenu(){
        System.out.println("\t==Create menu item==");
        System.out.println("1. Main Course");
        System.out.println("2. Dessert");
        System.out.println("3. Drink");
        System.out.println("4. Back");
        System.out.print("Enter option: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Input item's name, description and price");
                String name = sc.next();
                String desc = sc.next();
                double price = sc.nextDouble();
                MainCourse mc1 = new MainCourse(name, desc, price);
                menu.add(mc1);
                break;
            case 2:
                System.out.println("Input item's name, description and price");
                String name1 = sc.next();
                String desc1 = sc.next();
                double price1 = sc.nextDouble();
                Dessert mc2 = new Dessert(name1, desc1, price1);
                menu.add(mc2);
                break;
            case 3:
                System.out.println("Input item's name, description and price");
                String name2 = sc.next();
                String desc2 = sc.next();
                double price2 = sc.nextDouble();
                Drink mc3 = new Drink(name2, desc2, price2);
                menu.add(mc3);
                break;
            case 4:
        }
    }

    private static void createSet(){
        System.out.println("Enter Set Package name, description and price");
        String name = sc.next();
        String desc = sc.next();
        double price = sc.nextInt();
        SetPackage sp1 = new SetPackage(name, desc, price);
    }

    private static void editMenu() {
        int index = 0;
        int choice;
        System.out.println("\nSelect the menu item to edit:");
        for (MenuItems menuItem : menu) System.out.println("(" + index++ + ") " + menuItem.getName());
        System.out.print("Enter your choice : ");
        choice = sc.nextInt();
        try{
            System.out.println("Enter new name, new description and new price : ");
            String name = sc.next();
            String desc = sc.next();
            double price = sc.nextDouble();
            menu.get(choice).setName(name);
            menu.get(choice).setDescription(desc);
            menu.get(choice).setPrice(price);
        }catch(IndexOutOfBoundsException e) {
            System.out.println("Error! Invalid index entered!");
        }
    }

    private static void deleteMenu(){
        int index = 0;
        int choice;
        System.out.println("\nSelect the menu item to edit:");
        for (MenuItems menuItem : menu) System.out.println("(" + index++ + ") " + menuItem.getName());
        System.out.print("Enter your choice : ");
        choice = sc.nextInt();
        try{
            menu.remove(choice);
            System.out.println("Item has been removed");
        }catch(IndexOutOfBoundsException e) {
            System.out.println("Error! Invalid index entered!");
        }
    }
}

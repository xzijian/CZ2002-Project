package UI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.*;
import Managers.MenuMgr;

public class MenuUI {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<ArrayList<MenuItems>> menu = Restaurant.foodMenu;
    public static void MenuUIOptions() {
        System.out.println("\n\n");
        System.out.println("\t==Menu Options==");
        System.out.println("(1) Create new menu item");
        System.out.println("(2) Create new Set Package");
        System.out.println("(3) Edit Menu");
        System.out.println("(4) Edit Set");
        System.out.println("(5) Remove menu entry");
        System.out.println("(6) Back\n");
        System.out.print("Input your choice: ");
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
                    editSet();
                    break;
                case 5:
                    deleteMenu();
                    break;
                default:
                    System.out.println("Exiting Menu UI...");
            }
        } while (choice < 6);
    }
    private static void createMenu(){
        int choice;
        do {
            MenuMgr.printCategories();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Input Drink's name, description and price");
                    String name = sc.next();
                    String desc = sc.next();
                    double price = sc.nextDouble();
                    AlaCarte newDrink = new AlaCarte(name, desc, price, "Drinks");
                    menu.get(0).add(newDrink);
                    break;
                case 2:
                    System.out.println("Input Dessert's name, description and price");
                    String name1 = sc.next();
                    String desc1 = sc.next();
                    double price1 = sc.nextDouble();
                    AlaCarte newDessert = new AlaCarte(name1, desc1, price1, "Dessert");
                    menu.get(1).add(newDessert);
                    break;
                case 3:
                    System.out.println("Input Main Course's name, description and price");
                    String name2 = sc.next();
                    String desc2 = sc.next();
                    double price2 = sc.nextDouble();
                    AlaCarte newMain = new AlaCarte(name2, desc2, price2, "MainCourse");
                    menu.get(2).add(newMain);
                    break;
                case 4:
            }
        }while (choice < 4);
    }

    private static void createSet(){
        System.out.print("Enter name and description of new Set: ");
        String newName = sc.next();
        String newDescription = sc.next();
        SetPackage newSet = new SetPackage(newName, newDescription);
        MenuMgr.addMenuItemToSet(newSet.getSet());
        menu.get(3).add(newSet);
    }

    private static void editMenu() {
        int choice;
        do {
            MenuMgr.printCategoriesWoSet();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    MenuMgr.printDrinks();
                    System.out.println("Input your choice: ");
                    int n = sc.nextInt();
                    System.out.print("Enter new name, description and price: ");
                    String newName = sc.next();
                    String newDesc = sc.next();
                    double newPrice = sc.nextDouble();
                    MenuItems editedDrink = menu.get(0).get(n);
                    editedDrink.setName(newName);
                    editedDrink.setDescription(newDesc);
                    editedDrink.setPrice(newPrice);
                    break;
                case 2:
                    MenuMgr.printDesserts();
                    System.out.println("Input your choice: ");
                    int n1 = sc.nextInt();
                    System.out.print("Enter new name, description and price: ");
                    String newName1 = sc.next();
                    String newDesc1 = sc.next();
                    double newPrice1 = sc.nextDouble();
                    MenuItems editedDessert = menu.get(1).get(n1);
                    editedDessert.setName(newName1);
                    editedDessert.setDescription(newDesc1);
                    editedDessert.setPrice(newPrice1);
                    break;
                case 3:
                    MenuMgr.printMains();
                    System.out.print("Input your choice: ");
                    int n2 = sc.nextInt();
                    System.out.print("Enter new name, description and price: ");
                    String newName2 = sc.next();
                    String newDesc2 = sc.next();
                    double newPrice2 = sc.nextDouble();
                    MenuItems editedMainCourse = menu.get(0).get(n2);
                    editedMainCourse.setName(newName2);
                    editedMainCourse.setDescription(newDesc2);
                    editedMainCourse.setPrice(newPrice2);
                    break;
                case 4:
            }
        }while (choice <4);
    }

    private static void editSet(){
        int choice;
        do {
            System.out.println("\n\n");
            System.out.println("\t==Edit Set==");
            System.out.println("(1) Add Item to Set");
            System.out.println("(2) Remove Item from Set");
            System.out.println("(3) Edit Item from Set");
            System.out.println("(4) Back\n");
            System.out.print("Input your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    MenuMgr.printSets();
                    System.out.print("Input your choice: ");
                    int choice1 = sc.nextInt();
                    SetPackage goodSet = (SetPackage) menu.get(3).get(choice1);
                    MenuMgr.addMenuItemToSet(goodSet.getSet());
                    break;
                case 2:
                    MenuMgr.printSets();
                    System.out.println("Input your choice: ");
                    int choice2 = sc.nextInt();
                    SetPackage goodSet1 = (SetPackage) menu.get(3).get(choice2);
                    MenuMgr.removeMenuItems(goodSet1.getSet());
                    break;
                case 3:
                    MenuMgr.printSets();
                    System.out.println("Input your choice: ");
                    int choice3 = sc.nextInt();
                    SetPackage goodSet2 = (SetPackage) menu.get(3).get(choice3);
                    int index = 0;
                    for (MenuItems mi : goodSet2.getSet()){
                        System.out.println("(" + index++ + ")" + mi.getName());
                    }
                    System.out.print("Enter the item you want to edit: ");
                    int editAgain = sc.nextInt();
                    System.out.print("Enter new name, description and price: ");
                    String newName3 = sc.next();
                    String newDesc3 = sc.next();
                    double newPrice3 = sc.nextDouble();
                    MenuItems editedSet = menu.get(0).get(editAgain);
                    editedSet.setName(newName3);
                    editedSet.setDescription(newDesc3);
                    editedSet.setPrice(newPrice3);
                    break;
                case 4:
            }
        }while (choice < 4);
    }

    private static void deleteMenu() {
        int choice;
        do {
            MenuMgr.printCategories();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    MenuMgr.printDrinks();
                    System.out.println("Input your choice: ");
                    int n = sc.nextInt();
                    menu.get(0).remove(n);
                    break;
                case 2:
                    MenuMgr.printDesserts();
                    System.out.println("Input your choice: ");
                    int n1 = sc.nextInt();
                    menu.get(1).remove(n1);
                    break;
                case 3:
                    MenuMgr.printMains();
                    System.out.println("Input your choice: ");
                    int n2 = sc.nextInt();
                    menu.get(2).remove(n2);
                    break;
                case 4:
                    MenuMgr.printSets();
                    System.out.println("Input your choice: ");
                    int n3 = sc.nextInt();
                    menu.get(3).remove(n3);
                    break;
                case 5:
            }
        }while (choice < 5);
    }
}

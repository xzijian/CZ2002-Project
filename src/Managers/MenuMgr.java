package Managers;

import Entities.AlaCarte;
import Entities.MenuItems;
import Entities.Restaurant;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuMgr {
    private static ArrayList<ArrayList<MenuItems>> foodMenu = Restaurant.foodMenu;
    private static Scanner sc = new Scanner(System.in);

    public static void addMenuItems(ArrayList<MenuItems> array) {
        int choice;
        do {
            printCategories();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    printDrinks();
                    System.out.println("Enter ID to be added :");
                    int n = sc.nextInt();
                    addDrink(n, array);
                    break;
                case 2:
                    printDesserts();
                    System.out.println("Enter ID to be added :");
                    int o = sc.nextInt();
                    addDesserts(o, array);
                    break;
                case 3:
                    printMains();
                    System.out.println("Enter ID to be added :");
                    int p = sc.nextInt();
                    addMain(p, array);
                    break;
                case 4:
                    printSets();
                    System.out.println("Enter ID to be added :");
                    int q = sc.nextInt();
                    addSet(q, array);
                    break;
                case 5:
            }
        } while (choice < 5);
    }

    public static void addMenuItemToSet(ArrayList<MenuItems> array) {
        int choice;
        do {
            printCategoriesWoSet();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    printDrinks();
                    System.out.println("Enter ID to be added :");
                    int n = sc.nextInt();
                    addDrink(n, array);
                    break;
                case 2:
                    printDesserts();
                    System.out.println("Enter ID to be added :");
                    int o = sc.nextInt();
                    addDesserts(o, array);
                    break;
                case 3:
                    printMains();
                    System.out.println("Enter ID to be added :");
                    int p = sc.nextInt();
                    addMain(p, array);
                    break;
                case 4:
            }
        } while (choice < 4);
    }

    public static void removeMenuItems(ArrayList<MenuItems> array) {
        int index = 0;
        for (MenuItems mi : array){
            System.out.println("(" + index++ + ")" + mi.getName());
        }
        System.out.println("Enter the item you want to remove : ");
        int remove = sc.nextInt();
        array.remove(remove);
    }

    public static void printCategories(){
        System.out.println("(1) : Drinks");
        System.out.println("(2) : Desserts");
        System.out.println("(3) : Main Courses");
        System.out.println("(4) : Set Packages");
        System.out.println("(5) : Back");
        System.out.println();
        System.out.println("What is your choice? ");
    }

    public static void printCategoriesWoSet(){
        System.out.println("(1) : Drinks");
        System.out.println("(2) : Desserts");
        System.out.println("(3) : Main Courses");
        System.out.println("(4) : Back");
        System.out.println();
        System.out.println("What is your choice? ");
    }

    public static void printDrinks() {
        int index = 0;
        for (MenuItems mi : foodMenu.get(0)) {
            System.out.println("(" + index++ + ") " + mi.getName());
        }
    }

    public static void printDesserts() {
        int index = 0;
        for (MenuItems mi : foodMenu.get(1)) {
            System.out.println("(" + index++ + ") " + mi.getName());
        }
    }

    public static void printMains() {
        int index = 0;
        for (MenuItems mi : foodMenu.get(2)) {
            System.out.println("(" + index++ + ") " + mi.getName());
        }
    }

    public static void printSets() {
        int index = 0;
        for (MenuItems mi : foodMenu.get(3)) {
            System.out.println("(" + index++ + ") " + mi.getName());
        }
    }

    public static void addDrink(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(0).get(n));
    }

    public static void addDesserts(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(1).get(n));
    }

    public static void addMain(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(2).get(n));
    }

    public static void addSet(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(3).get(n));
    }
    public static void removeDrink(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(0).remove(n));
    }
    public static void removeDesserts(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(1).remove(n));
    }
    public static void removeMain(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(2).remove(n));
    }
    public static void removeSet(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(3).remove(n));
    }
}
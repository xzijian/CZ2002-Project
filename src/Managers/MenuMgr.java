package Managers;

import Entities.AlaCarte;
import Entities.MenuItems;
import Entities.Restaurant;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 Represents the Menu manager in restaurant
 @author Xie Zijian
 @version 1.0
 @since 2021-11-12
 */

public class MenuMgr {

    /**
     * The arrayList of arrayList of MenuItems.
     */

    private static ArrayList<ArrayList<MenuItems>> foodMenu = Restaurant.foodMenu;
    private static Scanner sc = new Scanner(System.in);

    /**
     * To add menu items to given arrayList.
     * @param array          arrayList of menu items being added to
     */
    public static void addMenuItems(ArrayList<MenuItems> array) {
        int flag = 1;
        int choice;
        while (flag == 1){
            printCategories();
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        printDrinks();
                        System.out.println("Enter ID to be added :");
                        int n = sc.nextInt();
                        try {
                            addDrink(n, array);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("Error! Invalid index entered!");
                        }
                        continue;
                    case 2:
                        printDesserts();
                        System.out.println("Enter ID to be added :");
                        int o = sc.nextInt();
                        try{
                            addDesserts(o, array);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("Error! Invalid index entered!");
                        }
                        continue;
                    case 3:
                        printMains();
                        System.out.println("Enter ID to be added :");
                        int p = sc.nextInt();
                        try{
                            addMain(p, array);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("Error! Invalid index entered!");
                        }
                        continue;
                    case 4:
                        printSets();
                        System.out.println("Enter ID to be added :");
                        int q = sc.nextInt();
                        try{
                            addSet(q, array);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("Error! Invalid index entered!");
                        }
                        continue;
                    case 5:
                        flag = 0;
                        break;
                    default:
                        System.out.println("Error! Invalid index entered!");
                }
            }catch(InputMismatchException ex) {
                System.out.println("Error! Invalid input entered!");
                sc.reset();
                sc.next();
            }
        }
    }

    /**
     * To add menu items to given set package.
     * @param array             arrayList of menu items in the set having items added to
     */

    public static void addMenuItemToSet(ArrayList<MenuItems> array) {
        int flag = 1;
        int choice;
        while(flag == 1) {
            printCategoriesWoSet();
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        printDrinks();
                        System.out.println("Enter ID to be added :");
                        int n = sc.nextInt();
                        try{
                            addDrink(n, array);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("Error! Invalid index entered!");
                        }
                        continue;
                    case 2:
                        printDesserts();
                        System.out.println("Enter ID to be added :");
                        int o = sc.nextInt();
                        try{
                            addDesserts(o, array);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("Error! Invalid index entered!");
                        }
                        continue;
                    case 3:
                        printMains();
                        System.out.println("Enter ID to be added :");
                        int p = sc.nextInt();
                        try{
                            addMain(p, array);
                        }catch (IndexOutOfBoundsException ex){
                            System.out.println("Error! Invalid index entered!");
                        }
                        continue;
                    case 4:
                        flag = 0;
                        break;
                    default:
                        System.out.println("Error! Invalid index entered!");
                }
            }catch(InputMismatchException ex){
                System.out.println("Error! Invalid input entered!");
                sc.reset();
                sc.next();
            }
        }
    }

    /**
     * To remove any menu items from given arrayList.
     * @param array                arrayList of menu items having items removed
     */

    public static void removeMenuItems(ArrayList<MenuItems> array) {
        int index = 0;
        for (MenuItems mi : array){
            System.out.println("(" + index++ + ")" + mi.getName());
        }
        System.out.println("Enter the item you want to remove : ");
        int remove = sc.nextInt();
        array.remove(remove);
    }

    /**
     * To display the categories of Menu Items.
     */
    public static void printCategories(){
        System.out.println("(1) : Drinks");
        System.out.println("(2) : Desserts");
        System.out.println("(3) : Main Courses");
        System.out.println("(4) : Set Packages");
        System.out.println("(5) : Back");
        System.out.println();
        System.out.println("What is your choice? ");
    }

    /**
     * To display the categories of Menu Items without Set Packages.
     */

    public static void printCategoriesWoSet(){
        System.out.println("(1) : Drinks");
        System.out.println("(2) : Desserts");
        System.out.println("(3) : Main Courses");
        System.out.println("(4) : Back");
        System.out.println();
        System.out.println("What is your choice? ");
    }

    /**
     * To display drinks.
     */

    public static void printDrinks() {
        int index = 0;
        for (MenuItems mi : foodMenu.get(0)) {
            System.out.println("(" + index++ + ") " + mi.getName());
        }
    }

    /**
     * To display desserts.
     */

    public static void printDesserts() {
        int index = 0;
        for (MenuItems mi : foodMenu.get(1)) {
            System.out.println("(" + index++ + ") " + mi.getName());
        }
    }

    /**
     * To display main courses.
     */

    public static void printMains() {
        int index = 0;
        for (MenuItems mi : foodMenu.get(2)) {
            System.out.println("(" + index++ + ") " + mi.getName());
        }
    }

    /**
     * To display sets.
     */

    public static void printSets() {
        int index = 0;
        for (MenuItems mi : foodMenu.get(3)) {
            System.out.println("(" + index++ + ") " + mi.getName());
        }
    }

    /**
     * To add drinks to given arrayList.
     */

    public static void addDrink(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(0).get(n));
    }

    /**
     * To add desserts to given arrayList.
     */

    public static void addDesserts(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(1).get(n));
    }

    /**
     * To add mains to given arrayList.
     */

    public static void addMain(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(2).get(n));
    }

    /**
     * To add set packages to given arrayList.
     */

    public static void addSet(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(3).get(n));
    }

    /**
     * To remove drinks from given arrayList.
     */

    public static void removeDrink(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(0).remove(n));
    }

    /**
     * To remove desserts from given arrayList.
     */

    public static void removeDesserts(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(1).remove(n));
    }

    /**
     * To remove mains from given arrayList.
     */

    public static void removeMain(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(2).remove(n));
    }

    /**
     * To remove sets from given arrayList.
     */

    public static void removeSet(int n, ArrayList<MenuItems> array) {
        array.add(foodMenu.get(3).remove(n));
    }
}
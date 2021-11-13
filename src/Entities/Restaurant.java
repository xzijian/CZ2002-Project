package Entities;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import Entities.Staff;
import Entities.Tables;
import Entities.AlaCarte;

public class Restaurant {
	
	//private String openingHours;
	//private boolean isOpen;
	//ArrayList<Staff> employeeStaff = new ArrayList<Staff>();
	
	
	
	public static final Path 	DATAPATH 					= Paths.get(System.getProperty("user.dir"), "data");
	public static final String 	RESTAURANT_FILE_NAME		= "restaurant.dat";	
	public static ArrayList<Staff> employeeStaff;
	public static ArrayList<Reservation> RestaurantTables;
	public static ArrayList<Order> orders;
	public static ArrayList<Order> completedOrders;
	public static ArrayList<ArrayList<MenuItems>> foodMenu;
	public static ArrayList<Customer> customersList;
	public static ArrayList<Invoice> invoices ;
	
	
	public static void saveState() {

		if(!Files.exists(DATAPATH)){
			System.out.println("Data folder not found!");
			File dir = new File(DATAPATH.toString());
			if(dir.mkdir()){
				System.out.println("Directory " + DATAPATH + " created...");
			}
		}
		
		Object[] restaurantState 	= {
				employeeStaff,
				RestaurantTables,
				orders,
				completedOrders,
				foodMenu,
				customersList,
				invoices};
		
		Path 				saveFileName 	= Paths.get(DATAPATH.toString(), RESTAURANT_FILE_NAME);
		FileOutputStream   	file 			= null;
		ObjectOutputStream 	out				= null;
		
		// Serialization 
        try
        {   
            //Saving of object in a file
            file = new FileOutputStream(saveFileName.toString());
            out = new ObjectOutputStream(file);
              
            // Method for serialization of object
            out.writeObject(restaurantState);
              
            out.close();
            file.close();
        }
          
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
	}
	
	public static void loadState() {
		Object[] restaurantState = null;
		Path saveData 				= Paths.get(DATAPATH.toString(), RESTAURANT_FILE_NAME);
		FileInputStream file 		= null;
		ObjectInputStream in 		= null;
		
		// Deserialization
        try
        {   
            // Reading the object from a file
            file = new FileInputStream(saveData.toString());
            in = new ObjectInputStream(file);
              
            // Method for deserialization of object
            restaurantState = (Object[])in.readObject();
            if(restaurantState != null){
				employeeStaff = (ArrayList<Staff>) restaurantState[0];
				RestaurantTables = (ArrayList<Reservation>) restaurantState[1];
				orders = (ArrayList<Order>) restaurantState[2];
				completedOrders = (ArrayList<Order>) restaurantState[3];
				foodMenu = (ArrayList<ArrayList<MenuItems>>) restaurantState[4];
				customersList = (ArrayList<Customer>) restaurantState[5];
				invoices = (ArrayList<Invoice>) restaurantState[6];
			}
              
            in.close();
            file.close();
        }
          
        catch(IOException ex)
        {
            System.out.println("IOException is caught lolol. lmao no .dat file yet so running default settings.");
            initRestaurant();
        }
          
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught. dun troll pls.");
            initRestaurant();
        }
	}
	
	public static void initRestaurant() {
		initStaff();
		initTables();
		initInvoices();
		initOrders();
		initCompletedOrders();
		initFoodMenu();
		initCustomer();
	}

	public static void initFoodMenu() {
		ArrayList<ArrayList<MenuItems>> menu = new ArrayList<ArrayList<MenuItems>>();
		for (int i = 0; i < 4; i++) {
			menu.add(new ArrayList<MenuItems>());
		}

		MenuItems coke = new AlaCarte("Coke", "coke", 2.50, "Drink");
		MenuItems water = new AlaCarte("Sparkling Water", "water", 2.00, "Drink");
		MenuItems greentea = new AlaCarte("Green Tea", "lucha", 3.50, "Drink");
		menu.get(0).add(coke);
		menu.get(0).add(water);
		menu.get(0).add(greentea);

		MenuItems tiramisu = new AlaCarte("Tiramisu", "egg", 7.90, "Dessert");
		MenuItems creme = new AlaCarte("Creme Brulee", "egg", 10.00, "Dessert");
		MenuItems nycheese = new AlaCarte("New York Cheesecake", "egg", 4.90, "Dessert");
		menu.get(1).add(tiramisu);
		menu.get(1).add(creme);
		menu.get(1).add(nycheese);

		MenuItems Fish = new AlaCarte("Fish & Chip", "fish", 11.50, "MainCourse");
		MenuItems Sirloin = new AlaCarte("Sirloin Steak", "cow", 16.90, "MainCourse");
		MenuItems impo = new AlaCarte("Impossible Meat Burger", "plant", 15.50, "MainCourse");
		menu.get(2).add(Fish);
		menu.get(2).add(Sirloin);
		menu.get(2).add(impo);
		Restaurant.foodMenu = menu;
	}
	public static void initTables() {
		Tables tables = new Tables(6, 3, 2);
		Restaurant.RestaurantTables = tables.getReservedTables();
	}
	public static void initCustomer(){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("Hermes", "12345678", true));
		Restaurant.customersList = customers;
	}
	public static void initStaff(){
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		staffs.add(new Staff("Xavier", true, 1, "Cashier"));
		staffs.add(new Staff("Brielle", false,2,"Boss"));

		Restaurant.employeeStaff = staffs;
	}

	public static void initOrders(){
		ArrayList<Order> order = new ArrayList<Order>();
		Restaurant.orders = order;
	}

	public static void initCompletedOrders(){
		ArrayList<Order> completedorders = new ArrayList<Order>();
		Restaurant.completedOrders = completedorders;
	}

	public static void initInvoices(){
		ArrayList<Invoice> invoices1 = new ArrayList<Invoice>();

		Restaurant.invoices = invoices1;
	}

	/*public Restaurant() {
		openingHours = "12pm-12am";
		isOpen = true;
		Tables totalTables = new Tables(6, 3, 2);
	}*/
	
	
}

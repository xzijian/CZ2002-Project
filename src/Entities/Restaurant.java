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

/**
 Represents a restaurant's reservation system.
 @author Chee Zi Hoe
 @version 1.0
 @since 2021-11-12
 */

public class Restaurant {

	/**
	 * An object that may be used to locate a file in a file system.
	 */

	public static final Path 	DATAPATH 					= Paths.get(System.getProperty("user.dir"), "data");

	/**
	 * The name to give for the data after serialization.
	 */

	public static final String 	RESTAURANT_FILE_NAME		= "restaurant.dat";

	/**
	 * The arraylist containing staff which is a restaurant object.
	 */

	public static ArrayList<Staff> employeeStaff;

	/**
	 * The arraylist containing reservation which is a restaurant object.
	 */

	public static ArrayList<Reservation> RestaurantTables;

	/**
	 * The arraylist containing orders which is a restaurant object.
	 */

	public static ArrayList<Order> orders;

	/**
	 * The arraylist containing completed orders which is a restaurant object.
	 */

	public static ArrayList<Order> completedOrders;

	/**
	 * The arraylist containing arrayLists of menu items which is a restaurant object.
	 */

	public static ArrayList<ArrayList<MenuItems>> foodMenu;

	/**
	 * The arraylist containing customers which is a restaurant object.
	 */

	public static ArrayList<Customer> customersList;

	/**
	 * The arraylist containing invoices which is a restaurant object.
	 */

	public static ArrayList<Invoice> invoices ;

	/**
	 * Saved the current instance of the restaurant.
	 * It does so by saving the restaurant objects in a file
	 * The instance is saved using serialization to translate file into byte stream
	 * IOException is catched also.
	 */

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

	/**
	 * Loads the state of the restaurant.
	 * It does so by reading the object from the file that was saved.
	 * It then deserialise the byte stream.
	 * Both IOException and ClassNotFoundException is catched and default settings are loaded when no file is found to read from.
	 *
	 */

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

	/**
	 * A method to initialize the default settings when the user runs the program for the first time
	 */

	public static void initRestaurant() {
		initStaff();
		initTables();
		initInvoices();
		initOrders();
		initCompletedOrders();
		initFoodMenu();
		initCustomer();
	}

	/**
	 * Initializes MenuItems in the restaurant and creates the arraylist for the arrayList of MenuItems for the restaurant object.
	 */

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

	/**
	 * Initializes table to the default values and creates the arraylist for the table restaurant object.
	 */

	public static void initTables() {
		Tables tables = new Tables(6, 3, 2);
		Restaurant.RestaurantTables = tables.getReservedTables();
	}

	/**
	 * Initializes customers in the restaurant and creates the arraylist for the customer restaurant object.
	 */

	public static void initCustomer(){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("Hermes", "12345678", true));
		Restaurant.customersList = customers;
	}

	/**
	 * Initializes staffs in the restaurant and creates the arraylist for the staff restaurant object.
	 */

	public static void initStaff(){
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		staffs.add(new Staff("Xavier", true, 1, "Cashier"));
		staffs.add(new Staff("Brielle", false,2,"Boss"));

		Restaurant.employeeStaff = staffs;
	}

	/**
	 * Creates the arraylist for the order restaurant object.
	 */

	public static void initOrders(){
		ArrayList<Order> order = new ArrayList<Order>();
		Restaurant.orders = order;
	}

	/**
	 * Creates the arraylist for the completed orders restaurant object.
	 */

	public static void initCompletedOrders(){
		ArrayList<Order> completedorders = new ArrayList<Order>();
		Restaurant.completedOrders = completedorders;
	}

	/**
	 * Creates the arraylist for the invoice restaurant object.
	 */

	public static void initInvoices(){
		ArrayList<Invoice> invoices1 = new ArrayList<Invoice>();

		Restaurant.invoices = invoices1;
	}
}

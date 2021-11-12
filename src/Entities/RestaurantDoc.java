import java.nio.file.Path;
import java.nio.file.Paths;

/**
	Represents a restaurant's reservation system.
	@author Chee Zi Hoe
	@version 1.0
	@since 2021-11-12
 */

public class Javadoc{
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
	 * The arraylist containing orders which is a restaurant object.
	 */
	public static ArrayList<Order> orders;
	
	/**
	 * The arraylist containing completed orders which is a restaurant object.
	 */
	public static ArrayList<Order> completedOrders;
	
	/**
	 * The arraylist containing the menu items which is a restaurant object.
	 */
	public static ArrayList<MenuItems> foodMenu;
	
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
              
            System.out.println("Object has been serialized");
  
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
				RestaurantTables = (Tables) restaurantState[1];
				orders = (ArrayList<Order>) restaurantState[2];
				completedOrders = (ArrayList<Order>) restaurantState[3];
				foodMenu = (ArrayList<MenuItems>) restaurantState[4];
				customersList = (ArrayList<Customer>) restaurantState[5];
				invoices = (ArrayList<Invoice>) restaurantState[6];
			}
              
            in.close();
            file.close();
              
            System.out.println("Object has been deserialized ");
            
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
	}
	
	/**
	 * Initializes table to the default values and creates the arraylist for the table restaurant object.
	 */
	public static void initTables() {
		Tables tables = new Tables(6, 3, 2);
		Restaurant.RestaurantTables = tables;
	}
	
	/**
	 * Initializes staffs in the restaurant and creates the arraylist for the staff restaurant object.
	 */
	
	public static void initStaff(){
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		staffs.add(new Staff("John", true, 1, "Dog"));

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
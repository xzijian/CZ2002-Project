
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Restaurant {
	
	private String openingHours;
	private boolean isOpen;
	//ArrayList<Staff> employeeStaff = new ArrayList<Staff>();
	
	
	
	public static final Path 	DATAPATH 					= Paths.get(System.getProperty("user.dir"), "data");
	public static final String 	RESTAURANT_FILE_NAME		= "restaurantSaveLoad.dat";	
	public static ArrayList<Staff> employeeStaff;
	public static ArrayList<MenuItems> foodMenu;
	public static ArrayList<Customer> customersList ;
	public static ArrayList<Order> orders;
	public static ArrayList<Order> completedOrders;
	
	
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
				customersList};
		
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
			System.out.println("State saved");
              
            out.close();
            file.close();
              
            System.out.println("Object has been serialized");
  
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
				customersList = (ArrayList<Customer>) restaurantState[1];
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
            System.out.println("ClassNotFoundException is caught. dun troll pls");
            initRestaurant();
        }
	}
	
	public static void initRestaurant() {
		initStaff();
		initFoodMenu();	
	}
	
	public static void initStaff(){
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		staffs.add(new Staff("John", true, 1, "Dog"));

		Restaurant.employeeStaff = staffs;
	}

	public static void initFoodMenu(){
		ArrayList<MenuItems> menuItems = new ArrayList<MenuItems>();
		AlaCarte AC1 = new AlaCarte("NSFC TAIWAN", "BEST", Category.MAINCOURSE, 0.99);
		menuItems.add((MenuItems) AC1);
		Restaurant.foodMenu = menuItems;
	}
	
	
}	

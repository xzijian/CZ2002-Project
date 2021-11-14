package Entities;
import java.io.Serializable;

/**
 Represents the menuitems in the restuarant.
 @author Brielle Gee
 @version 1.0
 @since 2021-11-12
 */

public abstract class MenuItems implements Serializable {

	/**
	 * This is the name of the menu item.
	 */

	private String Name;

	/**
	 * This is the description of the menu item.
	 */

	private String Description;

	/**
	 * The price of the menu item.
	 */

	protected double Price;

	/**
	 * This creates a menu with given name and description.
	 * @param name
	 * @param desc
	 */

	public MenuItems(String name, String desc) {
		this.Name = name;
		this.Description = desc;
	}

	/**
	 * Get the name of the menu item.
	 * @return this menu item's name
	 */

	public String getName() {
		return this.Name;
	}

	/**
	 * Change the name of the menu item.
	 * @param name
	 */

	public void setName(String name) {
		this.Name = name;
	}

	/**
	 * Get the description of the menu item.
	 * @return this menu item's description
	 */

	public String getDescription() {
		return this.Description;
	}

	/**
	 * Change the description of the menu item.
	 * @param desc           Description of this menu item
	 */

	public void setDescription(String desc) {
		this.Description = desc;
	}

	/**
	 * Get the price of the menu item.
	 * @return this menu item's price
	 */

	public abstract double getPrice();

	/**
	 * Change the price of the menu item.
	 * @param price            Price of this menu item
	 */

	public abstract void setPrice(double price);
	
}

package Entities;

import Entities.AlaCarte;
import Entities.Category;
import Entities.MenuItems;
import Managers.MenuMgr;

import java.io.Serializable;
import java.util.ArrayList;

/**
 Represents the set packages of the restaurant.
 @author Hermes Lim
 @version 1.0
 @since 2021-11-12
 */

public class SetPackage extends MenuItems implements Serializable {

	/**
	 * Instantiating the arrayList of MenuItems
	 */

	private ArrayList<MenuItems> set = new ArrayList<MenuItems>();

	/**
	 * The discount rate of the set packages.
	 */

	private double discountRate;

	/**
	 * Create a set package with given name, description.
	 * @param name        Name of set package
	 * @param desc		  Description of set package
	 */

	public SetPackage(String name, String desc) {
		super(name, desc);
		this.Price = 0;
		this.discountRate = 0.80;
	}

	/**
	 * Gets the discount rate of the set packages
	 * @return this set package's discount rate
	 */

	public double getDiscountRate() {
		return this.discountRate;
	}

	/**
	 * Change the discount rate of the set packages
	 * @param rate         Discount rate of set packages
	 */

	public void setDiscountRate(double rate) {
		this.discountRate = rate;
		this.Price = this.getPrice() * rate;
	}

	/**
	 * Get the set from the MenuItems array list
	 * @return this.set
	 */

	public ArrayList<MenuItems> getSet() {
		return this.set;
	}

	/**
	 * Add menu items to the set package.
	 * @param menu           arrayList of menu items
	 * @param itemID		 itemID of the item added
	 */

	public void addToSet(ArrayList<MenuItems> menu, int itemID) {
		set.add(menu.get(itemID));
	}

	/**
	 * Delete an item from set package.
	 * Can only use the itemID to do so.
	 * @param itemID			itemID of the item removed
	 */

	public void deleteFromSet(int itemID) {
		if (this.getSet().size() == 0 ) {
			System.out.println("No item to delete!");
		}
		else {
			while(true) {
				try {
					MenuItems alacarte = this.set.get(itemID);
					set.remove(itemID);
					return;
				}catch(IndexOutOfBoundsException e) {
					System.out.println("Invalid itemID");
					return;
				}
			}
		}
	}

	/**
	 * Get the price of set package after discount
	 * @return this set's discounted price
	 */

	public double getDiscountedPrice() {
		double sum = 0.0;
		for (MenuItems alacarte: set) {
			sum = alacarte.getPrice();
		}
		return sum * this.getDiscountRate();
	}

	/**
	 * Get the price of set package after discount
	 * @return this set's discounted price
	 */

	@Override
	public double getPrice() {
		double sum = 0.0;
		for (MenuItems alacarte: set) {
			sum = alacarte.getPrice();
		}
		return sum * this.getDiscountRate();
	}

	/**
	 * Change the price of the set.
	 */

	@Override
	public void setPrice(double price) {
		this.Price = price;
	}

	/**
	 * Print out items in a set.
	 */

	public void printFoodinSet() {
		System.out.println("Set name: " + this.getName());
		for (MenuItems alacarte: set) {
			System.out.println("ID: " + this.getSet().indexOf(alacarte) + 
						       "\nName: " + alacarte.getName() +
							   "\nDescription: " + alacarte.getDescription() +
							   "\nPrice: " + alacarte.getPrice());
		}
	}

}

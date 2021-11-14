package Entities;

import Entities.MenuItems;

import java.io.Serializable;
import java.util.Locale;
/**
 * Represents the AlaCarte menu in restaurant.
 * @author Brielle Gee
 * @version 1.0
 * @since 2021-11-12
 */
public class AlaCarte extends MenuItems implements Serializable {
	/**
	 * The price of the alacarte item.
	 */
	private double Price;
	/**
	 * The category of the alacarte item.
	 */
	private Category categoryType;
	/**
	 * Creates the alacarte item given name, description, price and category.
	 * @param name                Name of alacarte item
	 * @param desc                Description of alacarte item
	 * @param price               Price of alacarte item
	 * @param category            Category of alacarte item
	 */
	public AlaCarte(String name, String desc, double price, String category) {
		super(name, desc);
		this.Price = price;
		this.setCategory(category);
	}
	/**
	 * Get the price of the alacarte item.
	 * @return this alacarte's price
	 */
	@Override
	public double getPrice() {
		return this.Price;
	}
	/**
	 * Change the price of the alacarte item.
	 * @param price              Price of alacarte item
	 */
	@Override
	public void setPrice(double price) {
		this.Price = price;
	}
	/**
	 * Get the category of the alacarte menu
	 * @return this alacarte's category.
	 */
	public String getCategory() {
		return categoryType.category();
	}
	/**
	 * Change the category of the alacarte item.
	 * @param category             Category of this alacarte item
	 */
	public void setCategory(String category) {
		if (category.toUpperCase(Locale.ROOT).equals("DRINK")){
			this.categoryType = new Drink();
		}
		if (category.toUpperCase(Locale.ROOT).equals("MAINCOURSE")){
			this.categoryType = new MainCourse();
		}
		if (category.toUpperCase(Locale.ROOT).equals("DESSERT")){
			this.categoryType = new Dessert();
		}
	}
	/**
	 * Prints the alacarte item's attributes.
	 */
	public String toString() {
		String print = ("Name: " + this.getName() +
						"Description: "+ this.getDescription() +
						"Price: " + this.getPrice());
		return print;
	}
}

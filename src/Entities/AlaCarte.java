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
	 * Creates the alacarte item given name, description and price.
	 * @param name
	 * @param desc
	 * @param price
	 */
	public AlaCarte(String name, String desc, double price, String category) {
		super(name, desc);
		this.Price = price;
		this.setCategory(category);
	}
	@Override
	public double getPrice() {
		return this.Price;
	}
	@Override
	public void setPrice(double price) {
		this.Price = price;
	}

	public String getCategory() {
		return categoryType.category();
	}
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

	//print Entities.AlaCarte attributes
	public String toString() {
		String print = ("Name: " + this.getName() +
						"Description: "+ this.getDescription() +
						"Price: " + this.getPrice());
		return print;
	}
}

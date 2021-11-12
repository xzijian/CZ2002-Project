package Entities;

import Entities.MenuItems;

import java.util.Locale;

public class AlaCarte extends MenuItems {

	private double Price;
	private Category categoryType;
	
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

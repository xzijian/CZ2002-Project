package Entities;


import Entities.MenuItems;

public abstract class AlaCarte extends MenuItems {

	private double Price;

	
	public AlaCarte(String name, String desc, double price) {
		super(name, desc);
		this.Price = price;
	}
	
	@Override
	public double getPrice() {
		return this.Price;
	}
	@Override
	public void setPrice(double price) {
		this.Price = price;
	}
	
	public void Category() {
		System.out.println("Category: ");
	}
	
	
	//print AlaCarte attributes
	public String toString() {
		String print = ("Name: " + this.getName() +
						"Description: "+ this.getDescription() +
						"Price: " + this.getPrice());
		return print;
	}
}

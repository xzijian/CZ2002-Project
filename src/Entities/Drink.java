package Entities;

import Entities.MenuItems;
public class Drink extends AlaCarte{

	public Drink(String name, String desc, double price) {
		super(name, desc, price);
		// TODO Auto-generated constructor stub
	}
	public String getDrinkName() {
		return this.getName();
	}
	
	public void setDrinkName(String name) {
		this.setName(name);
	}
	
	public String getDrinkDesc() {
		return this.getDescription();
	}
	
	public void setDrinkDesc(String desc) {
		this.setDescription(desc);
	}
	
	public double getDrinkPrice() {
		return this.getPrice();
	}
	
	public void setDrinkPrice(double price) {
		this.setPrice(price);
	}
}

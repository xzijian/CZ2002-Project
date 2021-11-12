package Entities;

import Entities.AlaCarte;
import Entities.Category;
import Entities.MenuItems;
import Managers.MenuMgr;

import java.util.ArrayList;

public class SetPackage extends MenuItems {
	private ArrayList<MenuItems> set = new ArrayList<MenuItems>();
	private double discountRate;
	
	public SetPackage(String name, String desc) {
		super(name, desc);
		this.Price = 0;
		this.discountRate = 1;
	}
	public double getDiscountRate() {
		return this.discountRate;
	}
	public void setDiscountRate(double rate) {
		this.discountRate = rate;
		this.Price = this.getPrice() * rate;
	}
	public ArrayList<MenuItems> getSet() {
		return this.set;
	}
	//ID should start from 0
	public void addToSet(ArrayList<MenuItems> menu, int itemID) {
		set.add((AlaCarte)menu.get(itemID));
	}
	//only can delete via itemID
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
	public double getDiscountedPrice() {
		double sum = 0.0;
		for (MenuItems alacarte: set) {
			sum = alacarte.getPrice();
		}
		return sum * this.getDiscountRate();
	}
	@Override
	public double getPrice() {
		return this.Price;
	}
	@Override
	public void setPrice(double price) {
		this.Price = price;
	}
	//print out items in the set
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

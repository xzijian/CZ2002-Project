import Entities.AlaCarte;
import Entities.Category;
import Entities.MenuItems;

import java.util.ArrayList;

public class SetPackage extends MenuItems {
	private ArrayList<AlaCarte> set = new ArrayList<AlaCarte>();
	private double discountRate;
	
	public SetPackage(String name, String desc, Category type, double price) {
		super(name, desc, type);
		this.Price = price;
		this.discountRate = 1;
	}
	public double getDiscountRate() {
		return this.discountRate;
	}
	public void setDiscountRate(double rate) {
		this.discountRate = rate;
		this.Price = this.getPrice() * rate;
	}
	public ArrayList<AlaCarte> getSet() {
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
					AlaCarte alacarte = this.set.get(itemID);
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
		for (AlaCarte alacarte: set) {
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
		for (AlaCarte alacarte: set) {
			System.out.println("ID: " + this.getSet().indexOf(alacarte) + 
						       "\nName: " + alacarte.getName() + 
						       "\nEntities.Category: " + alacarte.getCategory() +
							   "\nDescription: " + alacarte.getDescription() +
							   "\nPrice: " + alacarte.getPrice());
		}
	}

}

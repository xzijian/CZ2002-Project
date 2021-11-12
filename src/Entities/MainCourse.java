package Entities;


import Entities.MenuItems;
public class MainCourse extends AlaCarte {

	public MainCourse(String name, String desc, double price) {
		super(name, desc, price);
		// TODO Auto-generated constructor stub
	}
	
	public String getMainName() {
		return this.getName();
	}
	
	public void setMainName(String name) {
		this.setName(name);
	}
	
	public String getMainDesc() {
		return this.getDescription();
	}
	
	public void setMainDesc(String desc) {
		this.setDescription(desc);
	}
	
	public double getMainPrice() {
		return this.getPrice();
	}
	
	public void setMainPrice(double price) {
		this.setPrice(price);
	}

}

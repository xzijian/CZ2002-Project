package Entities;

import java.io.Serializable;

public abstract class MenuItems implements Serializable {
	private String Name;
	private String Description;
	protected double Price;
	
	public MenuItems(String name, String desc) {
		this.Name = name;
		this.Description = desc;
	}
	public String getName() {
		return this.Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getDescription() {
		return this.Description;
	}
	public void setDescription(String desc) {
		this.Description = desc;
	}
	public abstract double getPrice();
	public abstract void setPrice(double price);
	
}

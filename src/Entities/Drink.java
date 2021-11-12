package entity;

public abstract class Drink extends AlaCarte{

	public Drink(String name, String desc, double price) {
		super(name, desc, price);
		// TODO Auto-generated constructor stub
	}
	public String getDrinkName() {
		return this.getName();
	}
	
	public void setDessertName(String name) {
		this.setName(name);
	}
	
	public String getDessertDesc() {
		return this.getDescription();
	}
	
	public void setDessertDesc(String desc) {
		this.setDescription(desc);
	}
	
	public double getDessertPrice() {
		return this.getPrice();
	}
	
	public void setDessertPrice(double price) {
		this.setPrice(price);
	}
}

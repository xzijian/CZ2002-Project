package entity;

public abstract class Dessert extends AlaCarte {
	
	

	public Dessert(String name, String desc, double price) {
		super(name, desc, price);
	}
	
	public String getDessertName() {
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

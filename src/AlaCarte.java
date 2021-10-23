

public class AlaCarte extends MenuItems{

	private double Price;
	
	public AlaCarte(String name, String desc, Category type, double price) {
		super(name, desc, type);
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
	//print AlaCarte attributes
	public String toString() {
		String print = ("Category: " + this.getCategory() +
						"Name: " + this.getName() +
						"Description: "+ this.getDescription() +
						"Price: " + this.getPrice());
		return print;
	}
}

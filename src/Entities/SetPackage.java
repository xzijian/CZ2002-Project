package Entities;
import java.util.ArrayList;

public class SetPackage extends MenuItems {
	private double discountRate;
	public SetPackage(String name, String desc, double price) {
		super(name, desc);
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
	@Override
	public double getPrice() {
		return this.Price;
	}
	@Override
	public void setPrice(double price) {
		this.Price = price;
	}
}

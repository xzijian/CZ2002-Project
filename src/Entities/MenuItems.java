package Entities;

public abstract class MenuItems {
	private String Name;
	private String Description;
	private Category Type;
	protected double Price;
	
	public MenuItems(String name, String desc, Category type) {
		this.Name = name;
		this.Description = desc;
		this.Type = type;
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
	public Category getCategory() {
		return this.Type;
	}
	public void setCategory(Category type) {
		this.Type = type;
	}
	public abstract double getPrice();
	public abstract void setPrice(double price);
	
}

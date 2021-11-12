package Entities;

public interface Category {
	String category();
}

class Drink implements Category{
	public String category() {
		return "Drinks";
	}
}

class Dessert implements Category{
	public String category() {
		return "Dessert";
	}
}

class MainCourse implements Category {
	public String category() {
		return "MainCourse";
	}
}


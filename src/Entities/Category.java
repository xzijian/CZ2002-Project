package Entities;

import java.io.Serializable;

public interface Category extends Serializable {
	String category();
}

class Drink implements Category {
	public String category() {
		return "Drink";
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


package Entities;
import java.io.Serializable;
/**
 Represents the different category of menu items.
 @author Brielle Gee
 @version 1.0
 @since 2021-11-12
 */

/**
 * A category interface.
 */
public interface Category extends Serializable {
	String category();
}
/**
 * The drink category.
 */
class Drink implements Category {
	public String category() {
		return "Drink";
	}
}
/**
 * The dessert category.
 */
class Dessert implements Category{
	public String category() {
		return "Dessert";
	}
}
/**
 * The maincourse category.
 */
class MainCourse implements Category {
	public String category() {
		return "MainCourse";
	}
}


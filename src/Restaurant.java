package restaurant;
import java.util.ArrayList;;

public class Restaurant {
	
	private String openingHours;
	private boolean isOpen;
	ArrayList<Staff> employeeStaff = new ArrayList<Staff>();
	
	
	public Restaurant() {
		openingHours = "12pm-12am";
		isOpen = true;
		Tables totalTables = new Tables(6, 3, 2);
	}
	
	public void addStaff(String name, boolean gender, int id, String jobTitle) {
		Staff staffTemplate = new Staff(name , gender, id, jobTitle);
		employeeStaff.add(staffTemplate);
	}
	
	public Staff getStaff(int id) {
		return employeeStaff.get(id-1);
	}
}

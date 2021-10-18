package restaurant;

public class Staff {
	private String staffName;
	private boolean gender;
	private int employeeId;
	private String jobTitle;
	
	public Staff(String staffName, boolean gender, int employerId, String jobTitle) {
		this.staffName = staffName;
		this.gender = gender;
		this.employeeId = employerId;
		this.jobTitle = jobTitle;
		
	}
	
	public String getStaffName() {
		return staffName;
	}
	
	public void setStaffName(String name) {
		staffName = name;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int id) {
		employeeId = id;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String title) {
		jobTitle = title;
	}
}

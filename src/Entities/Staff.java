package Entities;
import java.io.Serializable;

/**
 Represents the restaurant's staff
 @author Chee Zi Hoe
 @version 1.0
 @since 2021-11-12
 */

public class Staff implements Serializable{

	/**
	 * The name of the staff.
	 */

	private String staffName;

	/**
	 * To determine if staff is male or female.
	 */

	private boolean gender;

	/**
	 * The staff id.
	 */

	private int employeeId;

	/**
	 * The job title of the staff
	 */

	private String jobTitle;

	/**
	 * Creates a new staff with given name, gender, id and job title
	 * @param staffName
	 * @param gender
	 * @param employerId
	 * @param jobTitle
	 */
	
	public Staff(String staffName, boolean gender, int employerId, String jobTitle) {
		this.staffName = staffName;
		this.gender = gender;
		this.employeeId = employerId;
		this.jobTitle = jobTitle;
		
	}

	/**
	 * Gets the name of the staff.
	 * @return this staff's name
	 */

	public String getStaffName() {
		return staffName;
	}

	/**
	 * Change the name of the staff
	 * @param name
	 */

	public void setStaffName(String name) {
		staffName = name;
	}

	/**
	 * Gets the id of the staff.
	 * @return this staff's id.
	 */

	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Change the id of the staff.
	 * @param id
	 */

	public void setEmployeeId(int id) {
		employeeId = id;
	}

	/**
	 * Gets the job title of the staff
	 * @return this staff's job title
	 */

	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * Change the job title of the staff
	 * @param title
	 */

	public void setJobTitle(String title) {
		jobTitle = title;
	}
}

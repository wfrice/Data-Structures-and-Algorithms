package PriorityQueue;

public class Patient implements Priority, Order, Comparable<Patient> {

	private String firstName;
	private String lastName;
	private int priority;
	private int order;

	public Patient(String firstName, String lastName, int priority) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.priority = priority;
	}

	/**
	 * @return String return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return String return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return int return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public Integer getOrder() {
		return order;
	}

	@Override
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return this.priority + " : " + this.firstName + " " + this.lastName;
	}

	@Override
	public int compareTo(Patient o) {
		Integer pri = this.getPriority().compareTo(o.getPriority());
		if (pri != 0) {
			return pri;
		}
		else {
			return this.getOrder().compareTo(o.getOrder());
		}
	}

}

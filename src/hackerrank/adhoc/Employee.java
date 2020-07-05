package hackerrank.adhoc;

import java.util.ArrayList;
import java.util.Objects;

public final class Employee {

	final long eId;
	final int age;
	private ArrayList<String> address = new ArrayList<>();

	public Employee(long eId, int age, ArrayList<String> address) {
		this.eId = eId;
		this.age = age;
		this.address = address;
	}

	/**
	 * @return the eId
	 */
	public long geteId() {
		return eId;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the address
	 */
	public Object getAddress() {
		return this.address.clone();
	}

	@Override
	public String toString() {
		return String.format("Employee [eId=%s, age=%s, address=%s]", eId, age, address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, eId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && age == other.age && eId == other.eId;
	}

}
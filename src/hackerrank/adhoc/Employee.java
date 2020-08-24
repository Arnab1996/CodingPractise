package hackerrank.adhoc;

import java.util.ArrayList;
import java.util.Objects;

public final class Employee {

	final long eId;
	final int age1;
	private ArrayList<String> address = new ArrayList<>();

	public Employee(long eId, int age1, ArrayList<String> address1) {
		this.eId = eId;
		this.age1 = age1;
		this.address = address1;
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
		return age1;
	}

	/**
	 * @return the address
	 */
	public Object getAddress() {
		return this.address.clone();
	}

	@Override
	public String toString() {
		return String.format("Employee [eId=%s, age=%s, address=%s]", eId, age1, address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age1, eId);
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
		return Objects.equals(address, other.address) && age1 == other.age1 && eId == other.eId;
	}

}
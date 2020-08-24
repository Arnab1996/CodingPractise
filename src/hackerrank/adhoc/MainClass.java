package hackerrank.adhoc;

// Employee.java
final class Employee1 {
	private final String empName;
	private final int age;
	private final Address address;

	public Employee1(String name, int age, Address address) {
		super();
		this.empName = name;
		this.age = age;
		this.address = address;
	}

	public String getEmpName() {
		return empName;
	}

	public int getAge() {
		return age;
	}

	/*
	 * public Address getAddress() { return address; }
	 */
	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}
}

// Address.java
class Address implements Cloneable {
	public String addressType;
	public String address;
	public String city;

	public Address(String addressType, String address, String city) {
		super();
		this.addressType = addressType;
		this.address = address;
		this.city = city;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Address Type - " + addressType + ", address - " + address + ", city - " + city;
	}
}

// MainClass.java
public class MainClass {
	public static void main(String[] args) throws Exception {
		Employee1 emp = new Employee1("Adithya", 34, new Address("Home", "Madhapur", "Hyderabad"));
		Address address = emp.getAddress();
		System.out.println(address);
		address.setAddress("Hi-tech City");
		address.setAddressType("Office");
		address.setCity("Hyderabad");
		System.out.println(emp.getAddress());
		Student s = new Student("ABC", 101);
		System.out.println(s.getName());
		System.out.println(s.getRegNo());
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if (i > 5) {
				break;
			}
		}
		System.out.println("Not printed");
	}
}

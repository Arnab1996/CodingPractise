package hackerrank.adhoc;

//An immutable class 
public final class Student {
	final String name;
	final int regNo;

	public Student(String name, int regNo) {
		this.name = name;
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public int getRegNo() {
		return regNo;
	}
}

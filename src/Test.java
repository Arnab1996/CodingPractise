public class Test {

	static int noOfObjects = 0;

	// Instead of performing increment in the constructor
	// instance block is preferred to make this program generic.
	{
		noOfObjects += 1;
	}

	// various types of constructors
	// that can create objects
	public Test() {
	}

	public Test(int n) {
	}

	public Test(String s) {
	}

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		Test t1 = new Test();
		Test t2 = new Test(5);
		Test t3 = new Test("GFG");

		// We can also write t1.noOfObjects or
		// t2.noOfObjects or t3.noOfObjects
		System.out.println(Test.noOfObjects);
	}
}
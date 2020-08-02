package hackerrank.adhoc;

class Shared {

	synchronized void test1(Shared s2) {
		System.out.println("inside test1");
		test2(this);
		System.out.println("end test1");
	}

	synchronized void test2(Shared s1) {
		System.out.println("inside test2");
		test1(this);
		System.out.println("end test2");
	}
}

class Thread1 extends Thread {
	private Shared s1;
	private Shared s2;

	Thread1(Shared s1, Shared s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		// obtaining lock of s1
		s1.test1(s2);
	}
}

class Thread2 extends Thread {
	private Shared s1;
	private Shared s2;

	Thread2(Shared s1, Shared s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		// obtaining lock of s2
		s2.test2(s1);
	}

}

public class Deadlock {

	public static void main(String args[]) {
		Shared s1 = new Shared();
		Shared s2 = new Shared();
		Thread1 t1 = new Thread1(s1, s2);
		t1.start();
		// We will see that inside test1 gets printed here
		Thread2 t2 = new Thread2(s1, s2);

		t2.start();
		// We will see that inside test2 gets printed here
		// Then the program should get stopped
	}

}

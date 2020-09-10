package hackerrank.adhoc;

class SharedNow {
	synchronized public void test1(SharedNow s1) {
		System.out.println("Inside test1");
		test2(s1);
		System.out.println("Exitting test1");
	}

	synchronized public void test2(SharedNow s2) {
		System.out.println("Inside test1");
		test1(s2);
		System.out.println("Exitting test1");
	}
}

class Thread1Now extends Thread {
	private SharedNow s1 = new SharedNow();
	private SharedNow s2 = new SharedNow();

	public Thread1Now(SharedNow s1, SharedNow s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		s1.test1(s2);
	}
}

class Thread2Now extends Thread {
	private SharedNow s1 = new SharedNow();
	private SharedNow s2 = new SharedNow();

	public Thread2Now(SharedNow s1, SharedNow s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		s2.test2(s1);
	}
}

public class DeadNow {
	public static void main(String[] args) {
		SharedNow s1 = new SharedNow();
		SharedNow s2 = new SharedNow();
		Thread1Now t1 = new Thread1Now(s1, s2);
		t1.start();
		Thread2Now t2 = new Thread2Now(s1, s2);
		t2.start();
	}

}

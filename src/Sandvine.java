import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Sandvine {
	private static Sandvine SINGLE = null;

	private Sandvine() {
	}

	public static Sandvine getInstance() {

		if (SINGLE == null) {
			synchronized (Sandvine.class) {
				SINGLE = new Sandvine();
			}
		}
		return SINGLE;
	}

	static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(16);

	public static void publish(int m) {
		System.out.println("Published to Topic " + m);
		if (queue.size() == 16)
			System.out.println("Queue is full");
		else
			queue.add(m);
	}

	public static void receivedMessage() {
		if (!queue.isEmpty())
			System.out.println("Received from Topic " + queue.remove());
		else
			System.out.println("Queue is Empty");
	}

	public static void main(String[] args) throws Exception {
		Object O = getInstance();
		System.out.println(O.toString());
		Object O1 = getInstance();
		System.out.println(O1.toString());

		Thread t1 = new Thread() {
			public void run() {
				int i = 0;
				while (true) {
					publish(i++);
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					receivedMessage();
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}

}

/*
 * 
 * STUDENT(id, name) MARKS(subject, id, marks) Name subject, marks
 * 
 * select S.name, M.marks from STUDENT S, MARKS M where S.id = M.id;
 * 
 */
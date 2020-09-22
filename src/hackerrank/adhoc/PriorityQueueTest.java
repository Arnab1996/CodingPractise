package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueTest {
	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			minHeap.add(scanner.nextLong());
		}

		long count = 0;
		while (minHeap.size() > 1 && minHeap.peek() < k) {
			minHeap.add(minHeap.poll() + 2 * minHeap.poll());
			count++;
		}
		if (minHeap.peek() < k)
			System.out.println(-1);
		else
			System.out.println(count);

		scanner.close();
		System.gc();
	}
}

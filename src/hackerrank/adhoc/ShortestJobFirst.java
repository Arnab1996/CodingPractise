package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ShortestJobFirst {

	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int numOfCustomers = in.nextInt();
		Customer[] customers = new Customer[numOfCustomers];

		for (int i = 0; i < numOfCustomers; i++) {
			int orderTime = in.nextInt();
			int cookTime = in.nextInt();
			customers[i] = new Customer(orderTime, cookTime);
		}
		in.close();

		Arrays.sort(customers, Comparator.comparingInt(o -> o.orderTime));

		Queue<Customer> waitTime = new PriorityQueue<>();
		long currentTime = 0L;
		long totalWaitTime = 0L;
		int index = 0;

		while (!waitTime.isEmpty() || index < customers.length) {
			while (index < customers.length && customers[index].orderTime <= currentTime) {
				waitTime.add(customers[index]);
				index++;
			}
			if (waitTime.isEmpty()) {
				currentTime = customers[index].orderTime;
				continue;
			}

			Customer served = waitTime.poll();
			currentTime += served.cookTime;
			totalWaitTime += currentTime - served.orderTime;
		}

		System.out.println(totalWaitTime / customers.length);
		System.gc();
	}

	static class Customer implements Comparable<Customer> {
		int orderTime;
		int cookTime;

		public Customer(int orderTime, int cookTime) {
			this.orderTime = orderTime;
			this.cookTime = cookTime;
		}

		@Override
		public int compareTo(Customer o) {
			if (this.cookTime > o.cookTime) {
				return this.orderTime;
			} else
				return -1;
		}
	}
}

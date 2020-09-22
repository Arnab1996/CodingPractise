package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int gas;
	int next;

	public Pair(int gas, int next) {
		this.gas = gas;
		this.next = next;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gas;
		result = prime * result + next;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (gas != other.gas)
			return false;
		if (next != other.next)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [gas=" + gas + ", next=" + next + "]";
	}

}

public class TruckTour {
	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int t = scanner.nextInt();
		Queue<Pair> Q = new LinkedList<>();
		while (t-- > 0) {
			Q.add(new Pair(scanner.nextInt(), scanner.nextInt()));
		}

		int start = 0, passed = 0, gas = 0;
		while (passed < t) {
			Pair st = Q.poll();
			gas += st.gas;

			if (gas >= st.next) {
				passed += 1;
				gas -= st.next;
			} else {
				start += passed + 1;
				passed = 0;
				gas = 0;
			}
			Q.add(st);
		}
		System.out.println(start);
		scanner.close();
		System.gc();
	}
}

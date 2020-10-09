package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KosaRaju {
	static class DisjointSet {
		DisjointSet parent = this;
		int size = 1;

		DisjointSet findRoot() {
			if (parent != this) {
				// path compression
				parent = parent.findRoot();
			}

			return parent;
		}

		void union(DisjointSet other) {
			if (other == this)
				return;

			DisjointSet root = findRoot();
			DisjointSet otherRoot = other.findRoot();

			if (otherRoot == root)
				return;

			// union by size
			if (root.size >= otherRoot.size) {
				otherRoot.parent = root;
				root.size += otherRoot.size;
			} else {
				root.parent = otherRoot;
				otherRoot.size += root.size;
			}
		}
	}

	// lazily create a component
	static DisjointSet createComponentIfNeeded(DisjointSet[] components, int index) {
		if (components[index] == null) {
			components[index] = new DisjointSet();
		}

		return components[index];
	}

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int[] parents = new int[30001];

		int n = sc.nextInt();
		int a, b;

		while (n-- > 0) {

			a = sc.nextInt();
			b = sc.nextInt();

			if (parents[a] == 0)
				parents[a] = a;
			if (parents[b] == 0)
				parents[b] = a;

			// Disjoint set idea, keep updating the representative element of each set.
			if (parents[a] != 0 || parents[b] != 0) {
				int low = Math.min(parents[a], parents[b]);
				int high = Math.max(parents[a], parents[b]);
				for (int i = 0; i < parents.length; i++) {
					if (parents[i] == high)
						parents[i] = low;
				}
			}
		}

		// convert int[] to Integer[] in order to use Collections.frequency(Integer[],
		// int)
		Integer[] newArray = new Integer[parents.length];
		int i = 0;
		for (int value : parents) {
			newArray[i++] = value;
		}

		List<Integer> ints = Arrays.asList(newArray);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int item : newArray) {
			if (item != 0) {
				int frequency = Collections.frequency(ints, item);
				min = Math.min(min, frequency);
				max = Math.max(max, frequency);
			}
		}

		System.out.println(min + " " + max);
		sc.close();
		System.gc();
	}

}

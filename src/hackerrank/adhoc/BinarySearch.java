package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
		int size = ar.length;
		System.out.println("Missing number: " + search(ar, size));
		System.out.println(findmissing(ar, size));
		scanner.close();
		System.gc();
	}

	static int findmissing(int[] ar, int N) {

		int l = 0, r = N - 1;
		while (l <= r) {
			int mid = (l + r) / 2;

			// If this is the first element
			// which is not index + 1, then
			// missing element is mid+1
			if (ar[mid] != mid + 1 && ar[mid - 1] == mid)
				return (mid + 1);

			// if this is not the first
			// missing element search
			// in left side
			if (ar[mid] != mid + 1)
				r = mid - 1;

			// if it follows index+1
			// property then search
			// in right side
			else
				l = mid + 1;
		}

		// if no element is missing
		return -1;
	}
	
	
	
	/*
	 * An efficient solution is based on the divide and conquer algorithm that we
	 * have seen in binary search, the concept behind this solution is that the
	 * elements appearing before the missing element will have ar[i] – i = 1 and
	 * those appearing after the missing element will have ar[i] – i = 2.
	 * 
	 * This solution has a time complexity of O(log n)
	 */
	static int search(int ar[], int size) {
		int a = 0, b = size - 1;
		int mid = 0;
		while ((b - a) > 1) {
			mid = (a + b) / 2;
			if ((ar[a] - a) != (ar[mid] - mid))
				b = mid;
			else if ((ar[b] - b) != (ar[mid] - mid))
				a = mid;
		}
		return (ar[mid] + 1);
	}

}

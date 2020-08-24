package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
		int size = ar.length;
		System.out.println("Missing number: " + search(ar, size));
		scanner.close();
		System.gc();
	}

	public static int binarySearch(int arrayOfElements[]) {
		int leftIndex = 0, rightIndex = arrayOfElements.length - 1;
		int midElement = 0;
		while (leftIndex < rightIndex + 1) {
			midElement = (leftIndex + rightIndex) / 2;
			if (arrayOfElements[leftIndex] - leftIndex != arrayOfElements[midElement] - midElement) {
				rightIndex = midElement;
			} else if (arrayOfElements[rightIndex] - rightIndex != arrayOfElements[midElement] - midElement) {
				leftIndex = midElement;
			}
			return arrayOfElements[midElement] + 1;
		}
		return -1;
	}

	public static int search(int ar[], int size) {
		int leftIndex = 0, rightIndex = size - 1;
		int midElement = 0;
		while ((rightIndex - leftIndex) > 1) {
			midElement = (leftIndex + rightIndex) / 2;
			if ((ar[leftIndex] - leftIndex) != (ar[midElement] - midElement))
				rightIndex = midElement;
			else if ((ar[rightIndex] - rightIndex) != (ar[midElement] - midElement))
				leftIndex = midElement;
		}
		return (ar[midElement] + 1);
	}

	public static int flipBit(int number, int k) {
		System.out.println("Number in binary: " + Integer.toBinaryString(number));
		System.out.println("1 << k-1 in binary: " + Integer.toBinaryString(1 << k - 1));
		return number ^ (1 << k - 1);

	}

}

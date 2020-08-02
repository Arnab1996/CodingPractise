package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Findpairs {

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int arr[] = { 1, 5, 7, -1, 5 };
		int sum = 6;
		printPairs(arr, arr.length, sum);
		String str = "Abc";
		System.out.println(new String(new char[3]).replace("\0", str));
		scanner.close();
		System.gc();
	}

	private static void printPairs(int[] arr, int length, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			int rem = sum - arr[i];
			if (map.containsKey(rem)) {
				int count = map.get(rem);
				for (int j = 0; j < count; j++) {
					System.out.println("( " + rem + ", " + arr[i] + " )");
				}
			}
			map.merge(arr[i], 1, Integer::sum);
		}

	}

}

package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;

public class QueriesWithFixedLength {
	static int[] solve(int[] arr, int[] queries) {
		int n = arr.length;
		int[] ans = new int[queries.length];
		int maxi, mini, k;

		for (int i = 0; i < queries.length; i++) {
			maxi = 0;
			k = 0;
			for (int r = 0; r < queries[i]; r++) {
				if (arr[r] > maxi) {
					maxi = arr[r];
					k = r;
				}
			}
			mini = maxi;
			for (int s = 1, e = queries[i]; e < n; s++, e++) {
				if (s - 1 == k || arr[e] >= maxi) {
					maxi = arr[s];
					k = s;
					for (int r = s + 1; r <= e; r++) {
						if (arr[r] > maxi) {
							maxi = arr[r];
							k = r;
						}
					}
					if (maxi < mini)
						mini = maxi;
				}
			}
			ans[i] = mini;
		}

		return ans;
	}

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		int arr[] = new int[n];
		int queries[] = new int[d];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		for (int i = 0; i < d; i++) {
			queries[i] = scanner.nextInt();
		}
		int[] ans = solve(arr, queries);
		for (int i : ans) {
			System.out.println(i);
		}

		scanner.close();
		System.gc();
	}

}

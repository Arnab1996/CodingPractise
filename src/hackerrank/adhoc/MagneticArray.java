package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;

public class MagneticArray {

	static double search(double l, double h, double a[], int n) {
		double d = 0.0000000000001;
		double force = 0.0, m, x;
		m = l + (h - l) / 2.0;

		for (int i = 0; i < n; i++) {
			x = 1.0 / (m - a[i]);
			force += x;
		}

		if (Math.abs(force) < d) {
			return m;
		}

		if (force > 0) {
			return search(m, h, a, n);
		} else {
			return search(l, m, a, n);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt();
			double[] a = new double[n];

			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextDouble();
			}
			for (int i = 0; i < n - 1; i++) {
				double ans = search(a[i], a[i + 1], a, n);
				System.out.printf("%.2f ", ans);
			}
			System.out.println();

		}
		scanner.close();
		System.gc();
	}

}

package com.arnab.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BitonicPivot {
	static class FastScanner {
		BufferedReader s;
		StringTokenizer st;

		public FastScanner(InputStream InputStream) {
			st = new StringTokenizer("");
			s = new BufferedReader(new InputStreamReader(InputStream));
		}

		public FastScanner(File f) throws FileNotFoundException {
			st = new StringTokenizer("");
			s = new BufferedReader(new FileReader(f));
		}

		public int nextInt() throws IOException {
			if (st.hasMoreTokens())
				return Integer.parseInt(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextInt();
			}
		}

		public BigInteger big() throws IOException {
			if (st.hasMoreTokens())
				return new BigInteger(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return big();
			}
		}

		public double nextDouble() throws IOException {
			if (st.hasMoreTokens())
				return Double.parseDouble(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextDouble();
			}
		}

		public long nextLong() throws IOException {
			if (st.hasMoreTokens())
				return Long.parseLong(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextLong();
			}
		}

		public String nextString() throws IOException {
			if (st.hasMoreTokens())
				return st.nextToken();
			else {
				st = new StringTokenizer(s.readLine());
				return nextString();
			}
		}

		public String readLine() throws IOException {
			return s.readLine();
		}

		public void close() throws IOException {
			s.close();
		}
	}

	public static void merge(int arr[], int l, int mid, int r) {
		int temp[] = new int[100005];
		int i = l, j = mid + 1, k = l;
		while (i <= mid && j <= r) {
			if (arr[i] <= arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		while (i <= mid)
			temp[k++] = arr[i++];
		while (j <= r)
			temp[k++] = arr[j++];
		for (i = l; i <= r; i++)
			arr[i] = temp[i];
	}

	public static void stable_sort(int arr[], int l, int r) {
		if (l < r) {
			int mid = (l + r) >> 1;
			stable_sort(arr, l, mid);
			stable_sort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	public static int mod = 1000000007;

	public static long pow(long a, long b, long mod) {
		long x = 1;
		long y = a;
		while (b > 0) {
			if (b % 2 == 1) {
				x = (x * y);
				x %= mod;
			}
			y = (y * y);
			y %= mod;
			b /= 2;
		}
		return x;
	}

	public static long pow(long b, long e) {
		long r = 1;
		while (e > 0) {
			if (e % 2 == 1)
				r = r * b % mod;
			b = b * b % mod;
			e >>= 1;
		}
		return r;
	}

	public static long sum(long shift, long terms) {
		// sums 1 + 2^shift + 2^(2shift) + ... + 2^((terms-1) * shift)
		return (pow(2, shift * terms) + mod - 1) * pow(pow(2, shift) + mod - 1, mod - 2) % mod;
	}

	public static long divisor(long x) {
		long limit = x;
		int numberOfDivisors = 0;
		if (x == 1)
			numberOfDivisors = 1;
		for (int i = 1; i < limit; ++i) {
			if (x % i == 0) {
				limit = x / i;
				if (limit != i) {
					numberOfDivisors++;
				}
				numberOfDivisors++;
			}
		}
		return numberOfDivisors;
	}

	public static void findSubsets(long[] a) {
		long numOfSubsets = 1 << a.length;
		for (int i = 0; i < numOfSubsets; i++) {
			@SuppressWarnings("unused")
			int pos = a.length - 1;
			int bitmask = i;
			while (bitmask > 0) {
				if ((bitmask & 1) == 1)
					bitmask >>= 1;
				pos--;
			}
		}
	}

	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static boolean isPrime(int n) {
		boolean check = false;
		if (n == 1)
			return false;
		else {
			check = true;
			int l = (int) Math.sqrt(n);
			for (int i = 2; i <= l; ++i)
				if (n % i == 0) {
					check = false;
					i = n;
				}
		}
		return check;
	}

	public static long lcmofarray(int[] arr, long start, long end) {
		if ((end - start) == 1)
			return lcm(arr[(int) start], arr[(int) (end - 1)]);
		else
			return (lcm(arr[(int) start], lcmofarray(arr, start + 1, end)));
	}

	public static long lcm(long a, long b) {
		return (a * b / gcd(a, b));
	}

	public static long invl(long a, long mod) {
		long b = mod;
		long p = 1, q = 0;
		while (b > 0) {
			long c = a / b;
			long d;
			d = a;
			a = b;
			b = d % b;
			d = p;
			p = q;
			q = d - c * q;
		}
		return p < 0 ? p + mod : p;
	}

	public static char text[][] = new char[][] { { '.', ',', '?', '!', '1' }, { 'a', 'b', 'c', '2', '$' },
			{ 'd', 'e', 'f', '3', '$' }, { 'g', 'h', 'i', '4', '$' }, { 'j', 'k', 'l', '5', '$' },
			{ 'm', 'n', 'o', '6', '$' }, { 'p', 'q', 'r', 's', '7' }, { 't', 'u', 'v', '8', '$' },
			{ 'w', 'x', 'y', 'z', '9' }, { '_', '0', '$', '$', '$' } };
	////////////////////////////////////////////////////////////////////
	static InputStream inputStream = System.in;
	static FastScanner s = new FastScanner(inputStream);
	static OutputStream outputStream = System.out;
	static PrintWriter ww = new PrintWriter(new OutputStreamWriter(outputStream));
	@SuppressWarnings("unused")
	private static int[][] states = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static class BinarySearchComparator implements Comparator<Long> {
		@Override
		public int compare(Long o1, Long o2) {
			if (o1.equals(o2))
				return 0;
			else if (o1 < o2)
				return 1;
			else
				return -1;
		}
	}

	BinarySearchComparator comparator = new BinarySearchComparator();

	public static void main(String[] args) throws IOException {
		new BitonicPivot().solve();
		s.close();
		ww.close();
	}

	static int binarySearch(int arr[], int left, int right) {
		if (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
				return mid;

			if (arr[mid] < arr[mid + 1])
				return binarySearch(arr, mid + 1, right);
			else
				return binarySearch(arr, left, mid - 1);
		}

		return -1;
	}

	public void solve() throws IOException {
		/*
		 * long b = 0; int x = 100; while (x != 0) { b <<= 1; b |= (x & 1); x >>>= 1; }
		 * System.out.println(b);
		 */

		int T = s.nextInt();
		while (T-- > 0) {
			int n = s.nextInt();
			int[] arrayInput = new int[n];
			for (int i = 0; i < n; i++) {
				arrayInput[i] = s.nextInt();
			}
			System.out.println(binarySearch(arrayInput, 1, n - 2) != -1 ? binarySearch(arrayInput, 1, n - 2) : "-1");
		}
	}
}
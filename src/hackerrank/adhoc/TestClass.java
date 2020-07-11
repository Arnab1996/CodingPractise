package hackerrank.adhoc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TestClass {

	static final class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read(buf);
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public final int readInt() throws IOException {
			return (int) readLong();
		}

		public final long readLong() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
				if (c == -1)
					throw new IOException();
			}
			boolean negative = false;
			if (c == '-') {
				negative = true;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return negative ? -res : res;
		}

		public final int[] readIntArray(int size) throws IOException {
			int[] array = new int[size];
			for (int i = 0; i < size; i++) {
				array[i] = readInt();
			}
			return array;
		}

		public final long[] readLongArray(int size) throws IOException {
			long[] array = new long[size];
			for (int i = 0; i < size; i++) {
				array[i] = readLong();
			}
			return array;
		}

		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}

	static long mulmod(long a, long b, long mod) {
		long res = 0; // Initialize result
		a = a % mod;
		while (b > 0) {
			// If b is odd, add 'a' to result
			if (b % 2 == 1) {
				res = (res + a) % mod;
			}

			// Multiply 'a' with 2
			a = (a * 2) % mod;

			// Divide b by 2
			b /= 2;
		}

		// Return result
		return res % mod;
	}

	static long pow(long a, long b, long MOD) {
		long x = 1, y = a;
		while (b > 0) {
			if (b % 2 == 1) {
				x = (x * y);
				if (x > MOD)
					x %= MOD;
			}
			y = (y * y);
			if (y > MOD)
				y %= MOD;
			b /= 2;
		}
		return x;
	}

	static long[] f = new long[100001];

	static long InverseEuler(long n, long MOD) {
		return pow(n, MOD - 2, MOD);
	}

	static long C(int n, int r, long MOD) {

		return (f[n] * ((InverseEuler(f[r], MOD) * InverseEuler(f[n - r], MOD)) % MOD)) % MOD;
	}

	static int[] h = { 0, 0, -1, 1 };
	static int[] v = { 1, -1, 0, 0 };

	public static class Pair {
		public long s, e, cost, depth;
		int lca;

		public Pair(long s, long e, int lca, long cost, long depth) {
			this.s = s;
			this.e = e;
			this.lca = lca;
			this.cost = cost;
			this.depth = depth;
		}
	}

	static class Pair2 {
		public long cost;
		int node;

		public Pair2(long cos, int node) {
			this.cost = cos;
			this.node = node;
		}
	}

	static long compute_hash(String s) {
		int p = 31;
		int m = 1000000007;
		long hash_value = 0;
		long p_pow = 1;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			hash_value = (hash_value + (c - 'a' + 1) * p_pow) % m;
			p_pow = (p_pow * p) % m;
		}
		return hash_value;
	}

	static int counter = 0;
	static long answer = 0;

	public static void main(String[] args) throws Exception {
		// https://i...content-available-to-author-only...e.com/ebRGa6
		InputReader in = new InputReader(System.in);

		int n = in.readInt();
		Map<Long, Long> m = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			long mm = in.readLong();
			m.put(mm, m.getOrDefault(mm, 0L) + 1);
		}
		long answer = 0;
		for (Map.Entry<Long, Long> pair : m.entrySet()) {
			if (pair.getValue() > 2) {
				answer += pow(2, pair.getValue(), 1000000007);
				answer -= 1;
				answer -= pair.getValue();
				answer -= (pair.getValue() * (pair.getValue() - 1)) / 2;

				answer %= 1000000007;
				answer += 1000000007;

				answer %= 1000000007;
			}
		}

		System.out.println(answer);

	}

	private static void preprocess(int pos, int[][] pre, List<List<Integer>> tree, int[] traverse, int depth, int last,
			int[] tin, int[] tout) {
		tin[pos] = counter++;
		traverse[depth] = pos;

		for (int i = 0; depth - (1 << i) >= 0; ++i) {
			pre[pos][i] = traverse[depth - (1 << i)];
		}

		for (int i = 0; i < tree.get(pos).size(); ++i) {
			if (tree.get(pos).get(i) != last)
				preprocess(tree.get(pos).get(i), pre, tree, traverse, depth + 1, pos, tin, tout);
		}
		tout[pos] = counter++;
	}

	static int gcd(int a, int b) {

		while (b != 0) {
			int t = a;
			a = b;
			b = t % b;
		}
		return a;
	}

	static boolean submit = true;

	static void debug(String s) {
		if (!submit)
			System.out.println(s);
	}

	static void debug(int s) {
		if (!submit)
			System.out.println(s);
	}

}
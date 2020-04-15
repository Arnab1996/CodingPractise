package com.arnab.hackerrank;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SegmentTree {

	static int maxn = 100009;
	static int chainNo, ptr;
	static int chainHead[] = new int[maxn];
	static int posInBase[] = new int[maxn];
	static int chainInd[] = new int[maxn];
	static int baseArray[] = new int[maxn];
	static int dp[][] = new int[maxn][25];
	static int level[] = new int[maxn];
	static int sz[] = new int[maxn];
	static List<List<Integer>> adj = new ArrayList<List<Integer>>(maxn);
	static List<List<Integer>> costs = new ArrayList<List<Integer>>(maxn);

	static long splitmix64(long x) {
		// http://xorshift.di.unimi.it/splitmix64.c
		x += 0x9e3779b97f4a7c15L;
		x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9L;
		x = (x ^ (x >> 27)) * 0x94d049bb133111ebL;
		return x ^ (x >> 31);
	}

	static class Node {
		Node child[] = new Node[2];

		public Node() {
			this.child[0] = null;
			this.child[1] = null;
		}
	}

	static Node trieArr[] = new Node[4 * maxn + 1];

	public static void combine(Node root, Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return;
		root = new Node();
		if (root1 == null) {
			root = root2;
			return;
		}
		if (root2 == null) {
			root = root1;
			return;
		}
		combine(root.child[0], root1.child[0], root2.child[0]);
		combine(root.child[1], root1.child[1], root2.child[1]);
	}

	public static void insertInTrie(Node root, int val) {
		Node temp = root;
		for (int i = 31; i >= 0; i--) {
			int bitAt = val & (1 << i);
			if (temp.child[bitAt] == null) {
				temp.child[bitAt] = new Node();
			}
			temp = temp.child[bitAt];
		}
	}

	public static void build(int index, int low, int high) {
		if (low > high)
			return;
		if (low == high) {
			trieArr[index] = new Node();
			insertInTrie(trieArr[index], baseArray[low]);
			return;
		}
		int mid = low + (high - low) / 2;
		build(2 * index, low, mid);
		build(2 * index + 1, mid + 1, high);
		combine(trieArr[index], trieArr[2 * index], trieArr[2 * index + 1]);
	}

	public static int queryInTrie(Node root, int pref) {
		int maxVal = 0;
		Node curr = root;
		for (int i = 31; i >= 0; i--) {
			int b = (pref >> i) & 1;
			if (b == 0) {
				if (curr.child[1] != null) {
					maxVal += (1 << i);
					curr = curr.child[1];
				} else {
					curr = curr.child[0];
				}
			} else {
				if (curr.child[0] != null) {
					maxVal += (1 << i);
					curr = curr.child[0];
				} else {
					curr = curr.child[1];
				}
			}
		}
		return maxVal;
	}

	public static int query(int index, int low, int high, int l, int r, int x) {
		if (low > r || high < l || low > high)
			return 0;
		if (low >= l && high <= r)
			return queryInTrie(trieArr[index], x);
		int mid = low + (high - low) / 2;
		return Math.max(query(2 * index, low, mid, l, r, x), query(2 * index + 1, mid + 1, high, l, r, x));
	}

	public static void dfs(int v, int p, int d) {
		level[v] = d;
		dp[v][0] = p;
		sz[v] = 1;
		for (Integer u : adj.get(v)) {
			if (u == p)
				continue;
			dfs(u, v, d + 1);
			sz[v] += sz[u];
		}
	}

	public static void pre(int n) {
		for (int j = 1; j <= 20; j++) {
			for (int i = 1; i <= n; i++) {
				if (dp[i][j - 1] != -1)
					dp[i][j] = dp[dp[i][j - 1]][j - 1];
			}
		}
	}

	public static int lca(int a, int b) {
		if (level[a] < level[b]) {
			a = a ^ b ^ (b = a);
		}
		int diff = level[a] - level[b];
		for (int i = 0; i <= 20; i++) {
			if ((diff & (1 << i)) == 1)
				a = dp[a][i];
		}
		if (a == b) {
			return a;
		}
		for (int i = 20; i >= 0; i--) {
			if (dp[a][i] != dp[b][i]) {
				a = dp[a][i];
				b = dp[b][i];
			}
		}
		return dp[a][0];
	}

	public static void hld(int curNode, int cost, int prev) {
		if (chainHead[chainNo] == -1) {
			chainHead[chainNo] = curNode;
		}
		chainInd[curNode] = chainNo;
		posInBase[curNode] = ptr;
		baseArray[ptr++] = cost;
		int sc = -1;
		int ncost = 0;
		for (int i = 0; i < adj.get(curNode).size(); i++) {
			if (adj.get(curNode).get(i) != prev) {
				if (sc == -1 || sz[sc] < sz[adj.get(curNode).get(i)]) {
					sc = adj.get(curNode).get(i);
					ncost = costs.get(curNode).get(i);
				}
			}
		}
		if (sc != -1) {
			hld(sc, ncost, curNode);
		}
		for (int i = 0; i < adj.get(curNode).size(); i++) {
			if (adj.get(curNode).get(i) != prev) {
				if (sc != adj.get(curNode).get(i)) {
					chainNo++;
					hld(adj.get(curNode).get(i), costs.get(curNode).get(i), curNode);
				}
			}
		}
	}

	public static int queryUp(int u, int v, int x) {
		if (u == v)
			return 0;
		int vchain = chainInd[v];
		int uchain;
		int ans = 0;
		while (true) {
			uchain = chainInd[u];
			if (uchain == vchain) {
				if (u == v)
					break;
				ans = Math.max(ans, query(1, 0, ptr - 1, posInBase[v] + 1, posInBase[u], x));
				break;
			}
			ans = Math.max(ans, query(1, 0, ptr - 1, posInBase[chainHead[uchain]], posInBase[u], x));
			u = chainHead[uchain];
			u = dp[u][0];
		}
		return ans;
	}

	public static int getAns(int u, int v, int x) {
		int lc = lca(u, v);
		int ans1 = queryUp(u, lc, x);
		int ans2 = queryUp(v, lc, x);
		return Math.max(ans1, ans2);
	}

	public static int gcdExtended(int a, int b, int x, int y) {
		if (a == 0) {
			x = 0;
			y = 1;
			return b;
		}
		int x1 = 0, y1 = 0;
		int gcd = gcdExtended(b % a, a, x1, y1);
		x = y1 - (b / a) * x1;
		y = x1;
		return gcd;
	}

	public static int mpower(int x, int y, int p) {
		int res = 1;
		x = x % p;
		while (y > 0) {
			if ((y & 1) == 1) {
				res = (res * x) % p;
			}
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

	public static int power(int x, int y) {
		int res = 1;
		while (y > 0) {
			if ((y & 1) == 1) {
				res = res * x;
			}
			y = y >> 1;
			x = x * x;
		}
		return res;
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		int p = (int) Math.sqrt(n);
		for (int i = 5; i <= p; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		Arrays.fill(chainHead, 1);
		Arrays.fill(dp, -1);
		int n = scanner.nextInt();
		int q = scanner.nextInt();

		for (int i = 1; i <= n - 1; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
			costs.get(u).add(w);
			costs.get(v).add(w);
		}

		chainNo = 0;
		ptr = 0;
		dfs(1, 0, 0);
		pre(n);
		hld(1, 0, 0);
		build(1, 0, ptr - 1);

		while (q-- > 0) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int x = scanner.nextInt();
			System.out.println(getAns(u, v, x));
		}

		scanner.close();
		System.gc();
	}
}

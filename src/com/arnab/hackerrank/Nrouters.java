package com.arnab.hackerrank;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Nrouters {

	static int time = 0;

	private static List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
		time = 0;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < numRouters; i++) {
			map.put(i, new HashSet<>());
		}
		for (int[] link : links) {
			map.get(link[0]).add(link[1]);
			map.get(link[1]).add(link[0]);
		}
		Set<Integer> set = new HashSet<>();
		int[] low = new int[numRouters];
		int[] ids = new int[numRouters];
		int parent[] = new int[numRouters];
		Arrays.fill(ids, -1);
		Arrays.fill(parent, -1);
		for (int i = 0; i < numRouters; i++) {
			if (ids[i] == -1)
				dfs(map, low, ids, parent, i, set);
		}
		return new ArrayList<>(set);
	}

	private static void dfs(Map<Integer, Set<Integer>> map, int[] low, int[] ids, int[] parent, int cur,
			Set<Integer> res) {
		int children = 0;
		ids[cur] = low[cur] = ++time;
		for (int nei : map.get(cur)) {
			if (ids[nei] == -1) {
				children++;
				parent[nei] = cur;
				dfs(map, low, ids, parent, nei, res);
				low[cur] = Math.min(low[cur], low[nei]);
				if ((parent[cur] == -1 && children > 1) || (parent[cur] != -1 && low[nei] >= ids[cur]))
					res.add(cur);
			} else if (nei != parent[cur])
				low[cur] = Math.min(low[cur], ids[nei]);
		}
	}

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int numRouters1 = 7;
		int numLinks1 = 7;
		// int[][] links1 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 2, 5 }, { 5, 6
		// }, { 3, 4 } };
		for (int i = 0; i < 7; i++) {
			ArrayList<Integer> list1 = new ArrayList<>();
			if (i == 0) {
				list1.add(1);
				list1.add(2);
			}
			if (i == 1) {
				list1.add(3);
			}
			if (i == 2) {
				list1.add(3);
				list1.add(5);
			}
			if (i == 3) {
				list1.add(4);
			}
			if (i == 5) {
				list1.add(6);
			}
			list.add(i, list1);
		}

		int[][] links1 = new int[numRouters1][numLinks1];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				links1[i][j] = list.get(i).get(j);
			}
		}

		list.forEach(System.out::println);
		Arrays.deepToString(links1);

		System.out.println(getCriticalNodes(links1, numLinks1, numRouters1));
		scanner.close();
	}

}

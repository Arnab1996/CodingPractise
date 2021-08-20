package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class AdjacencyList {
	private LinkedList<Integer> adj[];

	public AdjacencyList(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	public int bfs(int source, int destination) {
		boolean vis[] = new boolean[adj.length];
		int parent[] = new int[adj.length];
		Queue<Integer> q = new LinkedList<>();

		q.add(source);
		parent[source] = -1;
		vis[source] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == destination)
				break;
			for (int neighbour : adj[cur]) {
				if (!vis[neighbour]) {
					vis[neighbour] = true;
					q.add(neighbour);
					parent[neighbour] = cur;
				}
			}
		}

		int cur = destination;
		int dis = 0;
		while (parent[cur] != -1) {
			System.out.print(cur + " -> ");
			cur = parent[cur];
			dis++;
		}
		System.out.println(source);
		return dis;
	}

	private boolean dfsUtil(int source, int destination, boolean vis[]) {
		if (source == destination)
			return true;

		for (int neighbour : adj[source]) {
			if (!vis[neighbour]) {
				vis[neighbour] = true;
				if (dfsUtil(neighbour, destination, vis))
					return true;
			}
		}
		return false;
	}

	public boolean dfs(int source, int destination) {
		boolean vis[] = new boolean[adj.length];
		vis[source] = true;
		return dfsUtil(source, destination, vis);
	}

	public boolean dfsStack(int source, int destination) {
		boolean vis[] = new boolean[adj.length];
		vis[source] = true;
		Stack<Integer> stack = new Stack<>();

		stack.push(source);

		while (!stack.isEmpty()) {
			int cur = stack.pop();

			if (cur == destination)
				return true;

			for (int neighbour : adj[cur]) {
				if (!vis[neighbour]) {
					vis[neighbour] = true;
					stack.push(cur);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		System.out.println("Enter the number of vertices and edges");

		int v = sc.nextInt();
		int e = sc.nextInt();

		AdjacencyList graph = new AdjacencyList(v);
		System.out.println("Enter " + e + " edges");
		for (int i = 0; i < e; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();

			graph.addEdge(source, destination);
		}

		System.out.println("Minimum Distance is : " + graph.bfs(0, 3));

		System.out.println("Possible path : " + graph.dfs(0, 3));

		sc.close();
	}

}

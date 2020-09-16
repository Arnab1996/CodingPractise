import java.util.LinkedList;
import java.util.Queue;

public class ArcesiumWordLadder {

	static class Graph {
		int u, v;
		String value;

		public Graph(int u, int v, String value) {
			// TODO Auto-generated constructor stub
			this.u = u;
			this.v = v;
			this.value = value;
		}

		boolean visited = false;
		Graph next;

		@Override
		public String toString() {
			return "Graph [u=" + u + ", v=" + v + ", value=" + value + ", visited=" + visited + ", next=" + next + "]";
		}

	}

	static Graph gr;

	public static void main(String[] args) {

		String source = "damp";
		String target = "like";

		// method to call pre-process to populate the graph with appropriate dictionary
		// words
		String arr[] = new String[] { "damp", "mamp", "lamp", "limp", "lime", "like" };
		preprocess(arr);
		System.out.println(gr);

		// Perform DFS on the above graph
		dfs(source, target);

		bfs(source, target);

	}

	private static void bfs(String source, String target) {
		Queue<Graph> Q = new LinkedList<Graph>();
		Q.add(gr);
		while (!Q.isEmpty()) {
			if (Q.peek().value.equals(target)) {
				System.out.println(target);
				return;
			}
			if (gr.next != null) {
				boolean consider = chechDiff(gr.value, gr.next.value);
				if (consider && !gr.visited) {
					Q.add(gr.next);
					gr.visited = true;
					System.out.println(gr.value);
					Q.poll();
				}
				gr = gr.next;
			}
		}

	}

	private static void dfs(String source, String target) {
		if (gr.value.equals(target)) {
			return;
		}

		if (!gr.visited) {
			boolean consider = chechDiff(gr.value, gr.next.value);
			if (consider) {
				dfs(gr.next.value, target);
				System.out.println(gr.next.value);
				gr.visited = true;
			}
		}
	}

	private static boolean chechDiff(String value, String value2) {
		if (value.length() != value2.length())
			return false;
		char[] char1 = value.toCharArray();
		char[] char2 = value2.toCharArray();
		int count = 0;
		for (int i = 0; i < char1.length; i++) {
			if (char1[i] != char2[i])
				count++;
		}
		if (count == 1)
			return true;
		else
			return false;
	}

	private static void preprocess(String[] arr) {
		gr = new Graph(0, 1, arr[0]);
		gr = new Graph(1, 2, arr[0]);
		gr = new Graph(2, 3, arr[0]);
		gr = new Graph(3, 4, arr[0]);
		gr = new Graph(4, 5, arr[0]);
	}
}
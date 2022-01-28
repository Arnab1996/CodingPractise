import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TestUpstox {

	// definition of queue node
	static class Node {
		// y-coordinate
		int y;
		// x-coordinate
		int x;
		// number of steps to reach (y,x)
		int steps;

		// constructor
		Node(int i, int j, int moves) {
			y = i;
			x = j;
			steps = moves;
		}
	};

	// traversal array along rows
	static int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
	// traversal array along columns
	static int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

	// BFS to return number of steps required to reach from source to target
	static int BFS(Node source, Node target, int N) {
		// set to mark a cell as visited
		HashSet<String> visited = new HashSet<>();
		// BFS queue
		Queue<Node> q = new LinkedList<>();
		// push the source node
		q.add(source);

		// BFS traversal
		while (!q.isEmpty()) {
			Node front = q.poll();

			// if target coordinate is reached
			if (front.y == target.y && front.x == target.x)
				return front.steps;

			// traverse all neighbors of current cell
			for (int i = 0; i < 8; i++) {
				int next_y = front.y + dy[i];
				int next_x = front.x + dx[i];

				// store coordinates of a cell as string
				String search = next_y + "|" + next_x;

				// move to neighbor cell if it is not visited lies within the N x N chessboard
				if (visited.contains(search) == false && next_y > 0 && next_x > 0 && next_y <= N && next_x <= N) {
					Node next = new Node(next_y, next_x, front.steps + 1);
					q.add(next);
					visited.add(search);
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// dimensions of the square chessboard
		int N = 8;
		// coordinates of source & target cell
		Node source = new Node(7, 0, 0);
		Node target = new Node(6, 1, -1);
		System.out.println("Number of steps : " + BFS(source, target, N));
	}

}

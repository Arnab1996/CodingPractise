package ctci.TreesGraphs;

class Node {
	private Node adjacent[];
	public int adjacentCount;
	private String vertex;
	public RouteBetweenNodes.State state;

	public Node(String vertex, int adjacentLength) {
		this.vertex = vertex;
		adjacentCount = 0;
		adjacent = new Node[adjacentLength];
	}

	public void addAdjacent(Node x) {
		if (adjacentCount < adjacent.length) {
			this.adjacent[adjacentCount] = x;
			adjacentCount++;
		} else {
			System.out.print("No more adjacent can be added");
		}
	}

	public Node[] getAdjacent() {
		return adjacent;
	}

	public String getVertex() {
		return vertex;
	}
}

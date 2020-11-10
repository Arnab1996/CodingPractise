
public class Test_PlayGames {
	// fun (linked list)
	// traversal on this list, values will be copied O(n): T
	// random pointers

	// 1->2->3->4->5
	// 1->3
	// 2->4
	// 3->1
	// 4->5
	// 5->2

	static class LL {

		int data;
		LL next;
		LL random;

		public LL(int data, LL next, LL random) {
			super();
			this.data = data;
			this.next = next;
			this.random = random;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + data;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((random == null) ? 0 : random.hashCode());
			return result;
		}

		@Override
		public String toString() {
			return "LL [data=" + data + ", next=" + next + ", random=" + random + "]";
		}

	}

	// ll1, ll2
	static LL copy(LL ll1) {

		LL node1 = ll1;
		LL ll2 = new LL(node1.data, node1.next, null);
		LL node2 = ll2;
		node1 = node1.next;
		node2 = node2.next;
		// constructor

		while (node1.next != null) {
			node2 = new LL(node1.data, null, null);
			node2 = node2.next;
			node1 = node1.next;
		}
		while (node1.next != null) {
			node1.next = node2;
			node2 = node2.next;
			node1 = node1.next;
		}

		while (node2.next != null) {
			node2.random = node1.next.random;
			node2 = node2.next;
			node1 = node1.next.next;
		}

		return ll2;
	}

	// ll2.random = ll1.next.random;

	public static void main(String[] args) {
		LL ll1 = new LL(1, new LL(2, null, null), new LL(3, null, null));
		ll1.next = new LL(2, new LL(3, null, null), new LL(4, null, null));
		ll1.next.next = new LL(3, new LL(4, null, null), new LL(5, null, null));
		ll1.next.next.next = new LL(4, new LL(5, null, null), new LL(3, null, null));
		System.out.println(ll1);
	}

}

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/*

 sdauhsd asdhaos dhao sdosdh sohd aodoasdsho
 
     a              A
 b       c     B.        C
 
     1              2
2         3    3.       4    
 
1. 2. 3. 4.

1.

1"+"2 --> 12



*/

interface Operations<T> {
	public void doSomeOperation(T t);
}

class Node<T> {
	T val;
	Node<T> left, right;

	Node(T val) {
		this.val = val;
		this.left = this.right = null;
	}

	void inorder(Node<T> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
	}

}

class DoOperation<T> implements Operations<T> {
	public void createTypetree(String type) {
		switch (type) {
		case "Integer":
			Node<Integer> rootInt = new Node<Integer>(1);
			rootInt.left = new Node<Integer>(2);
			rootInt.left = new Node<Integer>(3);
			break;

		case "Character":
			Node<Character> rootChar = new Node<Character>('a');
			rootChar.left = new Node<Character>('b');
			rootChar.left = new Node<Character>('c');
			break;
		}
	}

	@Override
	public void doSomeOperation(T t) {
		// TODO Auto-generated method stub

	}

}

class OracleWierdQuestion {
	public static void main(String[] args) {

		System.out.println("Enter the type of tree");
		Scanner sc = new Scanner(System.in);
		String type = sc.nextLine();
		DoOperation<Integer> doOperation = new DoOperation<Integer>();
		doOperation.createTypetree(type);

		sc.close();

		String input = "sdauhsd asdhaos dhao sdosdh sohd aodoasdsho";
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : input.toCharArray()) {
			if (c != ' ') {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}

		}

		for (Entry<Character, Integer> ele : map.entrySet()) {
			System.out.println(ele);
		}

	}
}

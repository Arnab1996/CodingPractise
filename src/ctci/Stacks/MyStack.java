package ctci.Stacks;

import java.util.EmptyStackException;

public class MyStack<T> {

	static int size = 10;
	static int capacity = 0;
	
	void init(){
		size = 10;
		capacity = 0;
	}

	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;

	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item) {
		capacity++;
		if(capacity > size) {
			throw new StackOverflowError();
		}
		StackNode<T> newTop = new StackNode<T>(item);
		newTop.next = top;
		top = newTop;
		System.out.print(top.data + " ^ ");
	}

	public T peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

}

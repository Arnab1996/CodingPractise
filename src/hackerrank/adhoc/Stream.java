package hackerrank.adhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface MyInterface {
	public void print();

	default void print1() {
		System.out.println("Inside print1");
	}

	default void print2() {
		System.out.println("Inside print2");
	}
}

public class Stream implements MyInterface {

	@Override
	public void print() {
		System.out.println("Inside Stream class");
	}

	@Override
	public void print2() {
		System.out.println("Inside Stream class print2");
	}

	public static void main(String[] args) {
		Stream stream = new Stream();
		stream.print();
		stream.print1();
		stream.print2();
		List<Integer> list = new ArrayList<>();
		list = Arrays.asList(5, 4, 3, 2);
		System.out.println(list.stream().map(p -> p * p).collect(Collectors.toList()));
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
		List<String> list1 = new ArrayList<>();
		list1 = Arrays.asList("Reflections", "Chinkal", "Arnab");
		System.out.println(list1.stream().filter(p -> p.startsWith("A")).collect(Collectors.toList()));
		list1.stream().map(a -> a.startsWith("C")).forEach(a -> System.out.print(a + " "));
		System.out.println();
		System.out.println(list.stream().reduce(0, Integer::sum));
		System.out.println(list.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i));
	}

}

package hackerrank.adhoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class MyDS {
	/*
	 * All operations in Theta(n) 1. Insert 2. Delete 3. Search 4. Get Random
	 */

	ArrayList<Integer> list;
	HashMap<Integer, Integer> map;

	public MyDS() {
		list = new ArrayList<>();
		map = new HashMap<>();
	}

	void insert(Integer data) {
		if (map.containsKey(data)) {
			System.out.println("Data already exists");
		} else {
			int s = list.size();
			list.add(data);
			map.put(data, s);
		}
	}

	Integer search(Integer data) {
		if (map.containsKey(data)) {
			return map.get(data);
		} else {
			System.out.print("Data " + data + " not found : return code ");
			return -1;
		}
	}

	Integer getRandom() {
		Random random = new Random();
		return list.get(random.nextInt(list.size()));
	}

	void delete(Integer data) {
		Integer index = map.get(data);
		if (index == null) {
			return;
		}
		int size = list.size();
		map.remove(data);
		int lastElement = list.get(size - 1);
		Collections.swap(list, index, size - 1);
		list.remove(size - 1);
		map.put(lastElement, index);
	}

	void printDS() {
		list.forEach(i -> System.out.print(i + "  "));
		System.out.println();
		map.forEach((i, j) -> System.out.println("Key : " + i + " -> Value : " + j));
		System.out.println();
	}

	public static void main(String[] args) {
		MyDS ds = new MyDS();
		ds.insert(2);
		ds.insert(4);
		ds.insert(6);
		ds.insert(10);
		System.out.println(ds.getRandom());
		System.out.println(ds.search(2));
		System.out.println(ds.search(3));
		ds.insert(6);
		ds.insert(30);
		ds.insert(40);
		System.out.println(ds.search(30));
		ds.printDS();
		ds.delete(30);
		System.out.println(ds.search(30));
		ds.insert(50);
		ds.printDS();
	}

}

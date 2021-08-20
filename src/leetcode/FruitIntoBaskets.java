package leetcode;

import java.util.HashMap;

public class FruitIntoBaskets {
	public static void main(String[] args) {
		FruitIntoBaskets baskets = new FruitIntoBaskets();
		System.out.println("Longest length is: " + baskets.totalFruit(new int[] { 1, 2, 3, 2, 2 }));
	}

	public int totalFruit(int[] fruits) {
		if (fruits == null || fruits.length == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		HashMap<Integer, Integer> map = new HashMap<>();
		int begin = 0, end = 0;

		while (end < fruits.length) {

			if (map.size() <= 2) {
				map.put(fruits[end], end++);
			}

			if (map.size() > 2) {
				int min = fruits.length - 1;
				for (int value : map.values()) {
					min = Math.min(min, value);
				}
				begin = min + 1;
				map.remove(fruits[min]);
			}
			max = Math.max(max, end - begin);
		}
		return max;
	}

}

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Test_Amazon {
	// write a function that sorts the given array in O(n) run time complexity
	// Arr : [ 0,1,2,0,0,2,1,1,2,0,0,0,2,1,1,1,0]

	// Empty
	// c1 = 0, => Count of 1s
	// c2 = 0, => Count of 2s
	// count of zero = length - (c1 + c2)

	// Step 1 -> For loop

	// HashMap<Integer, Frequency>

	static void sort2(int arr[]) {

		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		// O(n)
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else
				map.put(arr[i], map.get(arr[i]) + 1);
		}
		// {0,5} {1, 4} {2, 6}
		int i = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			// frequency for that entry
                      
			int len = entry.getValue();
			while (len-- > 0) {
				arr[i++] = entry.getKey();
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	static int[] sort(int arr[]) {
		int n = arr.length;
		int c1 = 0, c2 = 0;

		// Step 1
		for (int i : arr) {
			if (i == 1)
				c1++;
			if (i == 2)
				c2++;
		}

		// Step 2
		int i = 0;
		for (i = 0; i < n - (c1 + c2); i++) {
			arr[i] = 0;
		}
		while (c1 != 0) {
			arr[i++] = 1;
			c1--;
		}
		while (c2 != 0) {
			arr[i++] = 2;
			c2--;
		}

		return arr;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 0, 2, 1, 1, 1, 0 };
		sort2(arr);
		System.out.println(Arrays.toString(sort(arr)));
	}
}

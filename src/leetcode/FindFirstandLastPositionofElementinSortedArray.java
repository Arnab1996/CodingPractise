package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
	public static void main(String[] args) {
		FindFirstandLastPositionofElementinSortedArray array = new FindFirstandLastPositionofElementinSortedArray();
		System.out.println(Arrays.toString(array.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
	}

	public int[] searchRange(int nums[], int target) {
		int[] results = new int[2];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : nums) {
			list.add(i);
		}

		results[0] = list.indexOf(target);
		results[1] = list.lastIndexOf(target);

		return results;

	}

	int first(int arr[], int x, int n) {
		int low = 0, high = n - 1, res = -1;
		while (low <= high) {
// Normal Binary Search Logic
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;

// If arr[mid] is same as
// x, we update res and
// move to the left half.
			else {
				res = mid;
				high = mid - 1;
			}
		}
		return res;
	}

//If x is present in arr[] then returns
//the index of LAST occurrence of x in
//arr[0..n-1], otherwise returns -1
	int last(int arr[], int x, int n) {
		int low = 0, high = n - 1, res = -1;
		while (low <= high) {
// Normal Binary Search Logic
			int mid = (low + high) / 2;
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;

// If arr[mid] is same as x,
// we update res and move to
// the right half.
			else {
				res = mid;
				low = mid + 1;
			}
		}
		return res;
	}

}

package leetcode;

public class PeakIndexinaMountainArray {
	public static void main(String[] args) {
		PeakIndexinaMountainArray array = new PeakIndexinaMountainArray();
		System.out.println(array.peakIndexInMountainArray(new int[] { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 }));
	}

	public int peakIndexInMountainArray(int[] arr) {
		if (arr == null || arr.length < 3)
			return 0;
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			if (arr[i] > arr[i + 1])
				return i;
		}
		return 0;
	}
}

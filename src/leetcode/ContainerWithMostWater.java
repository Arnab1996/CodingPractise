package leetcode;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
		System.out.println(containerWithMostWater.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	public int maxArea(int[] height) {
		int len = height.length;
		int area = 0;
		int i = 0;
		int j = len - 1;
		while (i < j) {
			area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}

		return area;

	}
}

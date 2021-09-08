package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

	public static void main(String[] args) {
		MeetingRoomsII ii = new MeetingRoomsII();
		System.out.println(ii.minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
	}

	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int c = o1[0] - o2[0];
				if (c != 0) {
					return c;
				}
				return o1[1] - o2[1];
			}
		});
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int maxCount = 0;
		for (int i = 0; i < intervals.length; i++) {
			while (!pq.isEmpty() && pq.peek()[1] <= intervals[i][0]) {
				pq.poll();
			}
			pq.add(intervals[i]);
			maxCount = Math.max(maxCount, pq.size());
		}
		return maxCount;
	}

}

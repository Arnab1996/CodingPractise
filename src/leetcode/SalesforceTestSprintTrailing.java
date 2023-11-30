package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SprintTrailing {
    /*
    Imagine there are n points along a straight trail, while a runner run sprints of intervals between those point.
    The training plan is an array a[], which implies the runner should run from point a[i] to point a[i+1].

    For example, given n = 10, a = [2, 4, 1, 2].
    The runner should run from point 2 to point 4,
    then turn back from point 4 to point 1,
    and then from point 1 to point 2.

    Find the point that visited the most by runner after he finished training, i.e. in above example, point 2 is the most visited.
    If more than one point are visited the most, find the point with minimum index.
     */

    public static void main(String[] args) {
        int n = 5;
        List<Integer> sprints = new ArrayList<>();
        sprints.add(2);
        sprints.add(4);
        sprints.add(1);
        sprints.add(2);

        System.out.println(new SprintTrailing().getMostVisited(n, sprints));
    }

    public int getMostVisited(int n, List<Integer> sprints) {
        int[] visited = new int[n + 1];
        int max = 0;
        int result = 0;
        for (int i = 0; i < sprints.size() - 1; i++) {
            int start = sprints.get(i);
            int end = sprints.get(i + 1);
            if (end < start) {
                int temp = start;
                start = end;
                end = temp;
            }
            for (int j = start; j <= end; j++) {
                visited[j]++;
                if (visited[j] > max) {
                    max = visited[j];
                    result = j;
                }
            }
        }
        return result;

    }
}

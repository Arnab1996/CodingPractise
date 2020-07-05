package hackerrank.adhoc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSOnNumbers {
	static int[] dis = new int[1000001];

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Queue<Integer> Q = new LinkedList<Integer>();
			Q.add(n);
			dis[n] = 1;
			while (!Q.isEmpty()) {
				int now = Q.poll();
				if (dis[now - 1] == 0) {
					dis[now - 1] = dis[now] + 1;
					if (now - 1 == 0)
						break;
					Q.add(now - 1);
				}
				for (int i = 2; i * i <= now; i++) {
					if (now % i == 0) {
						int fac = Math.max(i, now / i);
						if (dis[fac] == 0) {
							dis[fac] = dis[now] + 1;
							Q.add(fac);
						}
					}
				}
			}
			System.out.println(dis[0] - 1);
			Arrays.fill(dis, 0);
		}
		scanner.close();
		System.gc();
	}
}
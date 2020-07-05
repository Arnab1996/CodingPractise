package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class KPermutation {

	static long fact_array[];
	static int done_till;

	public static long getFact(int n) {
		if (n > 20)
			n = 20;
		if (done_till >= n)
			return fact_array[n];
		while (done_till <= n) {
			done_till++;
			fact_array[done_till] = fact_array[done_till - 1] * (long) done_till;
		}
		return fact_array[n];
	}

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));

		fact_array = new long[27];
		done_till = 0;
		fact_array[0] = 1l;
		int t = scanner.nextInt();
		while (t-- > 0) {
			String ss = scanner.next();
			String nss = scanner.next();
			long k = scanner.nextLong();
			char newAlpha[] = new char[26];
			Arrays.fill(newAlpha, '-');
			boolean hash[] = new boolean[26];
			Arrays.fill(hash, false);
			for (int i = 0; i < ss.length(); i++) {
				newAlpha[ss.charAt(i) - 'a'] = nss.charAt(i);
				hash[nss.charAt(i) - 'a'] = true;
			}
			int index = 0;
			int factorial = 26 - ss.length();
			int i;
			i = 26;
			while (index < 26) {
				if (newAlpha[index] != '-') {
					index++;
					continue;
				}
				for (i = 0; i < 26; i++) {
					if (!hash[i]) {
						long fact = getFact(factorial - 1);
						if (fact < k)
							k = k - fact;
						else
							break;
					}
				}
				if (i == 26)
					break;
				newAlpha[index++] = (char) (i + 'a');
				hash[i] = true;
				factorial--;
			}
			if (i == 26)
				System.out.println("Not possible!");
			else {
				for (i = 0; i < 26; i++)
					System.out.print(newAlpha[i]);
				System.out.println();
			}
		}

		scanner.close();
	}

}

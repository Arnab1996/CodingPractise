package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;

public final class Arcesium {

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String str = "codes";
		String sub1 = "ode";
		String sub2 = "unt";
		System.out.println(substitute(str, sub1, sub2));
		scanner.close();
		System.gc();
	}

	private static String substitute(String str, String sub1, String sub2) {
		int len = str.length();
		int len1 = sub1.length();
		int len2 = sub2.length();

		char strArray[] = str.toCharArray();
		for (int i = 0; i < len; i++) {
			if (strArray[i] == sub1.charAt(0) && str.substring(i, i + len1).equals(sub1)) {
				for (int j = 0; j < len2; j++) {
					strArray[i + j] = sub2.charAt(j);
				}
			} else if (strArray[i] == sub2.charAt(0) && str.substring(i, i + len2).equals(sub2)) {
				for (int j = 0; j < len1; j++) {
					strArray[i + j] = sub1.charAt(j);
				}
			}
		}

		return String.valueOf(strArray);
	}

}

package hackerrank.adhoc;

public class CTF {
	public static void main(String[] args) {
		for (int i = 0; i < 26; i++) {
			System.out.println((int) (i + 1) + "      " + (char) ('a' + i));
		}
		char[] str = "764365547555553646272955453542".toCharArray();
		for (int i = 0; i < str.length; i++) {
			// System.out.print((char) ('a' + (int) str[i]));
			System.out.print((char) ('a' + Integer.valueOf(str[i])));
		}
	}
}

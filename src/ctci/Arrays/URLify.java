package ctci.Arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

public class URLify {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String input = scanner.nextLine();
		input = input.trim();
		input = input.replace(" ", "%20");
		System.out.println(input);
		scanner.close();
		System.gc();
	}
}

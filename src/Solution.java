import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		String input = sc.nextLine();
		ArrayList<Integer> list = new ArrayList<>();

		list = utility(":\\)", input, list);
		list = utility(";\\)", input, list);
		list = utility(":-\\)", input, list);
		list = utility(";-\\)", input, list);

		Collections.sort(list);
		for (Integer i : list)
			System.out.println(i);
		
		sc.close();
	}

	public static ArrayList<Integer> utility(String pattern, String string, ArrayList<Integer> list) {
		Matcher m = Pattern.compile(pattern).matcher(string);
		while (m.find()) {
			list.add(m.start());
		}
		return list;
	}
}

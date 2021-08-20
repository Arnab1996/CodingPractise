
public class FizzBuzz {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			String output = "";

			if (i % 3 == 0) {
				output += "Fizz";
			}
			
			if (i % 5 == 0) {
				output += "Buzz";
			}
			
			/**
			 * if (i % 7 == 0) { output += "Fuzz"; } if (i % 11 == 0) { output += "Bizz"; }
			 * if (i % 13 == 0) { output += "Biff"; }
			 */

			if (output.equals("")) {
				output = String.valueOf(i);
			}
			System.out.println(output);
		}
	}
}

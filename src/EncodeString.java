import java.util.Arrays;

public class EncodeString {
	public static void main(String[] args) {
		char[] charArray = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		System.out.println("Compressed string is : " + encodeStringInPlace(charArray));
	}

	private static String convertToChar(int number) {
		String result = "";
		while (number != 0) {
			result += ((char) (number % 10 + '0'));
			number /= 10;
		}
		return result;
	}

	public static String encodeString(char[] charArray) {
		int len = charArray.length;

		if (len <= 1)
			return charArray.toString();

		StringBuilder result = new StringBuilder("");

		int count = 1;
		char prev = charArray[0];
		char curr = charArray[0];

		for (int i = 1; i < len; i++) {
			curr = charArray[i];
			if (curr == prev) {
				count++;
			} else {
				result.append(prev);
				result.append(convertToChar(count));
				count = 1;
			}
			prev = curr;
		}
		result.append(prev);
		result.append(convertToChar(count));

		System.out.println("The length is : " + result.length());

		return result.toString();
	}

	public static int encodeStringInPlace(char[] charArray) {
		int len = charArray.length;

		if (len <= 1)
			return len;

		int index = 0;
		int hi = 0;

		while (hi < charArray.length) {

			int count = 0;
			char c = charArray[hi];
			while (hi < charArray.length && charArray[hi] == c) {
				hi++;
				count++;
			}

			charArray[index++] = c;
			if (count > 1) {
				while (count != 0) {
					charArray[index++] = ((char) (count % 10 + '0'));
					count /= 10;
				}
			}
		}

		System.out.println(Arrays.toString(charArray));
		return index;
	}

}

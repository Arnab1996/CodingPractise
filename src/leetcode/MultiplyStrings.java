package leetcode;

import java.math.BigInteger;

public class MultiplyStrings {
	public static void main(String[] args) {
		MultiplyStrings multiplyStrings = new MultiplyStrings();
		System.out.println(multiplyStrings.multiply("123", "345"));
	}

	public String multiply(String num1, String num2) {
		BigInteger a = new BigInteger(num1);
		BigInteger b = new BigInteger(num2);

		return String.valueOf(a.multiply(b));

	}
}

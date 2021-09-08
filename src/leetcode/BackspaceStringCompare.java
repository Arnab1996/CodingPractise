package leetcode;

public class BackspaceStringCompare {
	public static void main(String[] args) {
		BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
		System.out.println(backspaceStringCompare.backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceStringCompare.backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceStringCompare.backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceStringCompare.backspaceCompare("a#c", "b"));
	}

	public boolean backspaceCompare(String s, String t) {
		if (s == null || t == null)
			return false;
		int len1 = s.length();
		int len2 = t.length();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		for (int i = 0; i < len1; i++) {
			if (i != 0 && sb1.length() != 0 && s.charAt(i) == '#') {
				sb1.deleteCharAt(sb1.length() - 1);
			} else {
				if (s.charAt(i) != '#')
					sb1.append(s.charAt(i));
			}

		}

		for (int i = 0; i < len2; i++) {
			if (i != 0 && sb2.length() != 0 && t.charAt(i) == '#') {
				sb2.deleteCharAt(sb2.length() - 1);
			} else {
				if (t.charAt(i) != '#')
					sb2.append(t.charAt(i));
			}

		}

		System.out.println(sb1);
		System.out.println(sb2);

		return sb1.toString().equals(sb2.toString());
	}
}

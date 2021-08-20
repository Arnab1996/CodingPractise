package leetcode;

public class LicenseKeyFormatting {
	public static void main(String[] args) {

		LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
		String string = "2-4A0r7-4k";
		int k = 4;
		System.out.println(licenseKeyFormatting.licenseKeyFormattingMy(string, k));

	}

	private String licenseKeyFormattingMy(String string, int k) {
		StringBuilder sb = new StringBuilder();
		int len = string.length();
		for (int i = len - 1; i >= 0; i--)
			if (string.charAt(i) != '-') {
				if (sb.length() % (k + 1) == k) {
					sb.append('-');
				}
				sb.append(Character.toUpperCase(string.charAt(i)));
			}

		return sb.reverse().toString();
	}
}

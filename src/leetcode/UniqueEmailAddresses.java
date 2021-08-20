package leetcode;

import java.util.HashSet;

public class UniqueEmailAddresses {

	public static void main(String[] args) {
		String[] strArray = new String[] { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };

		UniqueEmailAddresses addresses = new UniqueEmailAddresses();
		System.out.println(addresses.numUniqueEmails(strArray));
	}

	public int numUniqueEmails(String[] emails) {
		HashSet<String> set = new HashSet<>();
		for (String str : emails) {
			set.add(computeEmail(str));
		}
		return set.size();
	}

	public String computeEmail(String str) {
		String[] arrOfStr = str.split("@", 2);
		String name = arrOfStr[0];
		String domain = arrOfStr[1];

		name = normaliseName(name);

		return name + '@' + domain;
	}

	public String normaliseName(String name) {
		String[] arrOfStr = name.split("\\+", 2);
		name = arrOfStr[0];
		name = name.replaceAll("\\.", "");
		return name;
	}

}

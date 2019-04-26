package com.vishal.interviews.google.easy;

import java.util.*;

public class UniqueEmailAddresses {

	public static void main(String[] args) {

		UniqueEmailAddresses u = new UniqueEmailAddresses();
		u.numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" });
	}

	public int numUniqueEmails(String[] emails) {

		Set<String> set = new HashSet<>();

		for (String s : emails) {
			String[] arr = s.split("@");
			arr[0] = arr[0].replaceAll("\\.", "");
			int plusIndex = arr[0].indexOf('+');
			String r = plusIndex == -1 ? arr[0] : arr[0].substring(0, plusIndex) + "@" + arr[1];
			set.add(r);
		}
		
		System.out.println(set);

		return set.size();
	}

}

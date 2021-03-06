package com.vishal.interviews.google.medium;

/**
 * 482. License Key Formatting
 * 
 * Now you are given a string S, which represents a software license key which
 * we would like to format. The string S is composed of alphanumerical
 * characters and dashes. The dashes split the alphanumerical characters within
 * the string into groups. (i.e. if there are M dashes, the string is split into
 * M+1 groups). The dashes in the given string are possibly misplaced.
 * 
 * We want each group of characters to be of length K (except for possibly the
 * first group, which could be shorter, but still must contain at least one
 * character). To satisfy this requirement, we will reinsert dashes.
 * Additionally, all the lower case letters in the string must be converted to
 * upper case.
 * 
 * So, you are given a non-empty string S, representing a license key to format,
 * and an integer K. And you need to return the license key formatted according
 * to the description above.
 * 
 * Example 1: Input: S = "2-4A0r7-4k", K = 4
 * 
 * Output: "24A0-R74K"
 * 
 * Explanation: The string S has been split into two parts, each part has 4
 * characters.
 * 
 * Example 2: Input: S = "2-4A0r7-4k", K = 3
 * 
 * Output: "24-A0R-74K"
 * 
 * Explanation: The string S has been split into three parts, each part has 3
 * characters except the first part as it could be shorter as said above.
 */
public class LicenseKeyFormatting {

	public static void main(String[] args) {

	}

	/**
	 * Java 5 lines clean solution
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public String licenseKeyFormattingClean(String s, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--)
			if (s.charAt(i) != '-')
				sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
		return sb.reverse().toString().toUpperCase();
	}

	/**
	 * Easy to understand using StringBuilder
	 * 
	 * @param S
	 * @param K
	 * @return
	 */
	public String licenseKeyFormattingUsingStringBuilder(String S, int K) {
		// Replacing all - and converting all letters to uppercase
		String S1 = S.replace("-", "");
		S1 = S1.toUpperCase();

		// Making stringBuilder
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S1.length(); i++) {
			sb.append(S1.charAt(i));
		}
		int len = sb.toString().length();
		// Inserting '-' from back at every K position
		for (int i = K; i < len; i = i + K) {
			sb.insert(len - i, '-');
		}
		return sb.toString();
	}

}

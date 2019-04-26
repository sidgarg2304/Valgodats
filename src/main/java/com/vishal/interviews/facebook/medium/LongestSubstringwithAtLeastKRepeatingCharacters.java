package com.vishal.interviews.facebook.medium;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestSubstring(String s, int k) {

		if (s == null || s.length() < k) {
			return 0;
		}
		return helper(s, k, 0, s.length());
	}

	int helper(String s, int k, int st, int en) {

		if (en - st < k) {
			return 0;
		}
		int[] count = new int[26];
		for (int i = st; i < en; i++) {
			count[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (count[i] <= 0 || count[i] >= k) {
				continue;
			}
			// since all characters should appear at least k times and since we
			// found some character which is not appearing k times, we find left
			// part and right part max in all the cases where the char is
			// present in the string
			for (int j = st; j < en; j++) {
				if (s.charAt(j) - 'a' == i) {
					return Math.max(helper(s, k, st, j), helper(s, k, j + 1, en));
				}
			}
		}

		return en - st;
	}

}

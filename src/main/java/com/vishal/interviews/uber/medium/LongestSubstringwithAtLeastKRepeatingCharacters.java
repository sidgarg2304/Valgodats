package com.vishal.interviews.uber.medium;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {

	}

	public int longestSubstring(String s, int k) {

		if (s == null || s.length() < k) {
			return 0;
		}

		return helper(s, 0, s.length(), k);
	}

	int helper(String s, int st, int en, int k) {
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
			
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) - 'a' == i) {
					return Math.max(helper(s, st, j, k), helper(s, j + 1, en, k));					
				}
			}
			
		}

		return en - st;
	}

}

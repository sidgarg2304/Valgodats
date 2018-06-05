package com.vishal.interviews.topinterviewquestions.medium;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

		int[] cnt = new int[26];
		for (int i = st; i < en; i++) {
			cnt[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (cnt[i] <= 0 || cnt[i] >= k) {
				continue;
			}
			for (int j = st; j < en; j++) {
				if (i == s.charAt(j) - 'a') {
					int leftMax = helper(s, st, j, k);
					int rightMax = helper(s, j + 1, en, k);
					return Math.max(leftMax, rightMax);
				}
			}

		}
		return en - st;
	}

}

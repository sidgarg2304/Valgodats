package com.vishal.interviews.leetcodereremaining.medium;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 *
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {

	}

	public int longestSubstring(String s, int k) {

		if (s == null || s.length() < k) {
			return 0;
		}
		return helper(s.toCharArray(), 0, s.length(), k);
	}

	int helper(char[] arr, int st, int en, int k) {

		if (en - st < k) {
			return 0;
		}
		int[] count = new int[26];
		for (int i = st; i < en; i++) {
			count[arr[i] - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (count[i] <= 0 || count[i] >= k) {
				continue;
			}

			for (int j = st; j < en; j++) {
				if (i == arr[j] - 'a') {
					int leftMax = helper(arr, st, j, k);
					int rightMax = helper(arr, j + 1, en, k);
					return Math.max(leftMax, rightMax);
				}
			}
		}

		return en - st;
	}
}

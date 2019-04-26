package com.vishal.interviews.uber.medium;

import java.util.*;

public class PalindromePermutationII {

	public static void main(String[] args) {

	}

	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		int[] count = new int[256];
		int numOfOdds = 0;
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
			numOfOdds += count[s.charAt(i)] % 2 == 1 ? 1 : -1;
		}

		if (numOfOdds > 1) {
			return res;
		}

		String mid = "";
		int leftPalindromeCnt = 0;
		for (int i = 0; i < 256; i++) {
			if (count[i] <= 0) {
				continue;
			}
			if (count[i] % 2 == 1) {
				mid += "" + (char) (i);
				count[i]--;
			}
			count[i] /= 2;
			leftPalindromeCnt += count[i];
		}
		dfs(mid, count, leftPalindromeCnt, "", res);
		return res;
	}

	void dfs(String mid, int[] count, int len, String cur, List<String> res) {
		if (len == cur.length()) {
			res.add(cur + mid + new StringBuilder(cur).reverse().toString());
			return;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				count[i]--;
				dfs(mid, count, len, cur + (char) i, res);
				count[i]++;
			}
		}
	}

}

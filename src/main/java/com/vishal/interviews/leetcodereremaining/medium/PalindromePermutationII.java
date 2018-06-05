package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

/**
 * 267. Palindrome Permutation II
 * 
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * For example:
 * 
 * Given s = "aabb", return ["abba", "baab"].
 * 
 * Given s = "abc", return [].
 * 
 * 
 */
public class PalindromePermutationII {

	public static void main(String[] args) {

		System.out.println(generatePalindromes("adba"));
	}

	public static List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<>();

		if (s == null || s.length() == 0) {
			return res;
		}

		int numOdds = 0;
		int[] count = new int[256];
		for (char c : s.toCharArray()) {
			count[c]++;
			numOdds = (count[c] & 1) == 1 ? numOdds + 1 : numOdds - 1;
		}

		if (numOdds > 1) {
			return res;
		}

		String mid = "";
		int lenOfHalfPalindrome = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				if ((count[i] & 1) == 1) {
					mid += "" + (char) i;
					count[i]--;
				}
				count[i] /= 2;
				lenOfHalfPalindrome += count[i];
			}
		}

		dfs(mid, "", lenOfHalfPalindrome, count, res);

		return res;
	}

	static void dfs(String mid, String cur, int len, int[] count, List<String> res) {
		if (len == cur.length()) {
			res.add(cur + mid + new StringBuilder(cur).reverse());
			return;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				count[i]--;
				dfs(mid, cur + (char) i, len, count, res);
				count[i]++;
			}
		}
	}

}

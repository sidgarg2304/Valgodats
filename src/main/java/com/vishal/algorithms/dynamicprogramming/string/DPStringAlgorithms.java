package com.vishal.algorithms.dynamicprogramming.string;

import java.util.HashSet;
import java.util.Set;

import com.vishal.algorithms.string.palindrome.PalindromeAlgorithms;

public class DPStringAlgorithms {

	public static void main(String[] args) {		
//		testLongestPalindromicSubstring();
//		testLongestPalindromicSubsequence();		
		testMinNumOfSplitsToMakeAllSubwordsPalindromes();
//		testcanWordBeSplitIntoValidDictionaryWords();
	}

	public static String longestPalindromicSubstring(String s) {
		int[][] dp = new int[s.length()][s.length()];
		String res = "";
		for (int i = 0; i < s.length() - 1; i++) {
			dp[i][i] = 1;
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
			}
		}
		dp[s.length() - 1][s.length() - 1] = 1;

		for (int l = 3; l <= s.length(); l++) {
			for (int i = 0; i <= s.length() - l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 1;
					res = s.substring(i, j + 1);
				}
			}
		}

		printSingleStringDPMatrix(s, dp);
		return res;

	}

	public static int longestPalindromicSubsequence(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < s.length() - 1; i++) {
			dp[i][i] = 1;
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 2;
			} else {
				dp[i][i + 1] = 1;
			}
		}
		dp[s.length() - 1][s.length() - 1] = 1;

		for (int l = 3; l <= s.length(); l++) {
			for (int i = 0; i <= s.length() - l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}

		printSingleStringDPMatrix(s, dp);

		return dp[0][s.length() - 1];
	}

	public static boolean canWordBeSplitIntoValidDictionaryWords(String s, Set<String> words) {
		int[][] dp = new int[s.length()][s.length()];

		for (int l = 1; l <= s.length(); l++) {
			for (int i = 0; i <= s.length() - l; i++) {
				int j = i + l - 1;
				String sub = s.substring(i, j + 1);
				if (words.contains(sub)) {
					dp[i][j] = 1;
				} else {
					for (int k = i; k < j; k++) {
						if (dp[i][k] == 1 && dp[k + 1][j] == 1) {
							dp[i][j] = 1;
							break;
						}
					}
				}
			}
		}
		printSingleStringDPMatrix(s, dp);
		return dp[0][s.length() - 1] == 1;
	}

	public static int minNumOfSplitsToMakeAllSubwordsPalindromes(String s) {
		int[][] dp = new int[s.length()][s.length()];

		for (int i = 0; i < dp.length - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
			}
		}

		for (int l = 3; l <= s.length(); l++) {
			for (int i = 0; i <= s.length() - l; i++) {
				int j = i + l - 1;
				String subString = s.substring(i, j + 1);
				if (PalindromeAlgorithms.isValidPalindrome(subString)) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Integer.MAX_VALUE - 1;
					for (int k = i; k < j; k++) {
						dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
					}
				}

			}
		}

		printSingleStringDPMatrix(s, dp);

		return dp[0][s.length() - 1];

	}

	public static void printSingleStringDPMatrix(String s, int[][] dp) {

		System.out.println("");
		System.out.print("     ");
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + " ");
		}

		System.out.println("");
		System.out.print("     ");
		for (int i = 0; i < s.length(); i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.print("     ");
		for (int i = 0; i < s.length(); i++) {
			System.out.print("--");
		}
		System.out.println("");
		for (int i = 0; i < dp.length; i++) {
			System.out.print(s.charAt(i) + " ");
			System.out.print(i + "| ");
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void testcanWordBeSplitIntoValidDictionaryWords() {
		Set<String> words = new HashSet<String>();
		words.add("am");
		words.add("i");
		words.add("ace");
		words.add("a");
		System.out
				.println("'iamace' " + (canWordBeSplitIntoValidDictionaryWords("iamace", words) ? "can be" : "cannot be")
						+ " split into valid words of dictionary ");
	}

	public static void testLongestPalindromicSubstring() {
		System.out.println("longest palindromic substring for 'abdcdbf' is " + longestPalindromicSubstring("abdcdbf"));
	}

	public static void testLongestPalindromicSubsequence() {
		System.out.println("longest palindromic sub sequence for 'agbdba' is " + longestPalindromicSubsequence("agbdba"));
	}

	public static void testMinNumOfSplitsToMakeAllSubwordsPalindromes() {
		String s = "abdbm";
		System.out.println("min number of splits to make all subwords of string " + s + " palindromes  is "
				+ minNumOfSplitsToMakeAllSubwordsPalindromes(s));
	}

}

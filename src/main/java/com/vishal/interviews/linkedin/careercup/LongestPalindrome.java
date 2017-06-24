package com.vishal.interviews.linkedin.careercup;
import java.util.*;

/**
 * 409. Longest Palindrome
 * 
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 *
 */
public class LongestPalindrome {

	public static void main(String[] args) {

		System.out.println(maxLengthPalindrome(new int[] { 1, 2, 1, 3, 3, 3, 3 }));
	}

	static int maxLengthPalindrome(int[] nums) {
		Set<Integer> set = new HashSet<>();

		int cnt = 0;
		for (int i : nums) {
			if (!set.add(i)) {
				set.remove(i);
				cnt += 2;
			}
		}

		if (!set.isEmpty()) {
			cnt += 1;
		}

		return cnt;
	}
}

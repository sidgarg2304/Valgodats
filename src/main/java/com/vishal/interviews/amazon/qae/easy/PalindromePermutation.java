package com.vishal.interviews.amazon.qae.easy;

import java.util.*;

/**
 * 266
 * 
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example, "code" -> False, "aab" -> True, "carerac" -> True. yakak - true,
 * mmo - true
 *
 */
public class PalindromePermutation {

	public static void main(String[] args) {

		System.out.println(canPermutePalindrome("mmo"));
		System.out.println(canPermutePalindrome("code"));
	}

	public static boolean canPermutePalindrome(String s) {

		Set<Character> set = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			if (!set.add(s.charAt(i))) {
				set.remove(s.charAt(i));
			}
		}

		return set.isEmpty() || set.size() == 1;
	}

}

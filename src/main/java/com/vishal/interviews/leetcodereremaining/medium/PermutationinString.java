package com.vishal.interviews.leetcodereremaining.medium;

import java.util.Arrays;

public class PermutationinString {

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));

	}

	public static boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 > len2)
			return false;

		int[] count = new int[26];

		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i) - 'a']--;
			count[s2.charAt(i) - 'a']++;
		}

		if (allZero(count)) {
			return true;
		}

		int st = 0;
		int en = len1;

		while (en < len2) {
			count[s2.charAt(st++) - 'a']--;
			count[s2.charAt(en++) - 'a']++;
			
			if (allZero(count)) {
				return true;
			}			
		}
		return false;
	}

	private static boolean allZero(int[] count) {

		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}

		return true;
	}
}

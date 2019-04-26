package com.vishal.interviews.facebook.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();

		if (s.length() < p.length()) {
			return res;
		}

		int[] countP = new int[26];
		int[] countS = new int[26];

		for (char c : p.toCharArray()) {
			countP[c - 'a']++;
		}
		System.out.println(Arrays.toString(countP));

		for (int left = 0, right = 0; right < s.length(); right++) {
			countS[s.charAt(right) - 'a']++;
			
			while (countS[s.charAt(right) - 'a'] > countP[s.charAt(right) - 'a']) {
				countS[s.charAt(left++) - 'a']--;
			}
			
			if (right - left + 1 == p.length()) {
				res.add(left);
			}
		}
		return res;
	}

}

package com.vishal.interviews.facebook.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<>();

		int res = 0;
		int st = 0;
		for (int i = 0; i < s.length(); i++) {
			while (set.contains(s.charAt(i))) {
				set.remove(s.charAt(st++));
			}
			set.add(s.charAt(i));
			res = Math.max(res, i - st + 1);
		}
		return res;
	}

}

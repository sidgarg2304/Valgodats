package com.vishal.interviews.uber.medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

	}

	public int lengthOfLongestSubstring(String s) {

		if(s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<>();
		int st = 0;
		int res = 1;
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

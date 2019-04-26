package com.vishal.interviews.facebook.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		int st = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);

			while (map.size() > k) {
				char r = s.charAt(st);
				map.put(r, map.get(r) - 1);
				if (map.get(r) == 0) {
					map.remove(r);
				}
				st++;
			}
			max = Math.max(max, i - st + 1);
		}
		return max;
	}

}

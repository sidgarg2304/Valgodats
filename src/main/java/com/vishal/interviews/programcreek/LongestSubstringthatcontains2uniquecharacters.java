package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * Given a string, find the longest substring that contains only two unique
 * characters. For example, given "abcbbbbcccbdddadacb", the longest substring
 * that contains 2 unique character is "bcbbbbcccb".
 */
public class LongestSubstringthatcontains2uniquecharacters {

	public static void main(String[] args) {

	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int maxLen = 0;

		Map<Character, Integer> map = new HashMap<>();
		int st = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			map.put(c, map.getOrDefault(c, 0) + 1);

			while (st < s.length() && map.size() > 2) {
				char p = s.charAt(st);
				map.put(p, map.get(p) - 1);
				if (map.get(p) == 0) {
					map.remove(p);
				}
				st++;
			}

			maxLen = Math.max(maxLen, i - st + 1);
		}
		return maxLen;
	}

}

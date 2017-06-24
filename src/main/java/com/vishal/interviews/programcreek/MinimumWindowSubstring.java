package com.vishal.interviews.programcreek;

import java.util.*;

public class MinimumWindowSubstring {

	public static void main(String[] args) {

	}

	public String minWindow(String s, String t) {

		Map<Character, Integer> inputMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			inputMap.put(c, inputMap.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> map = new HashMap<>();
		int st = 0;

		int resLen = Integer.MAX_VALUE;
		int len = 0;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (inputMap.containsKey(c)) {
				map.put(c, map.getOrDefault(c, 0) + 1);
				if (map.get(c) <= inputMap.get(c)) {
					len++;
				}
			}

			if (len == t.length()) {

				char p = s.charAt(st);

				if (!inputMap.containsKey(p) || inputMap.get(p) < map.get(p)) {
					if (map.containsKey(p) && map.get(p) > inputMap.get(p)) {
						map.put(p, map.get(p) - 1);
					}
					st++;
					p = s.charAt(st);
				}

				int curLen = i - st + 1;
				if (curLen < resLen) {
					resLen = curLen;
					res = s.substring(st, i + 1);
				}
			}
		}
		return res;
	}

}

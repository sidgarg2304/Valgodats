package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
 *
 */
public class WordPatternII {

	public static void main(String[] args) {

	}

	public boolean wordPatternMatch(String pattern, String str) {

		if (pattern == null && str == null) {
			return true;
		} else if (pattern == null || str == null) {
			return false;
		}

		return dfs(pattern, str, 0, 0, new HashMap<>());
	}

	boolean dfs(String pattern, String s, int p, int pos, Map<Character, String> map) {

		if (p == pattern.length() && pos == s.length()) {
			return true;
		}

		if (p >= pattern.length() || pos >= s.length()) {
			return false;
		}

		char c = pattern.charAt(p);
		for (int i = pos; i < s.length(); i++) {
			String sub = s.substring(pos, i + 1);
			if (!map.containsKey(c) && !map.containsValue(sub)) {
				map.put(c, sub);

				if (dfs(pattern, s, p + 1, i + 1, map)) {
					return true;
				}
				map.remove(c);
			} else if (map.containsKey(c) && map.get(c).equals(sub)) {
				if (dfs(pattern, s, p + 1, i + 1, map)) {
					return true;
				}

			}
		}
		return false;

	}

}

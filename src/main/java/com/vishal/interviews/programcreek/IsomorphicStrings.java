package com.vishal.interviews.programcreek;

import java.util.*;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);

			if (map.containsKey(a)) {
				if (map.get(a) != b) {
					return false;
				}
			} else {
				if (map.containsValue(b)) {
					return false;
				}
				map.put(a, b);
			}

		}
		return true;
	}
}

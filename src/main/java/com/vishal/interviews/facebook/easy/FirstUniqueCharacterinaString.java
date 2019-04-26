package com.vishal.interviews.facebook.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int firstUniqChar(String s) {

		if (s == null || s.length() == 0) {
			return -1;
		}
		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

}

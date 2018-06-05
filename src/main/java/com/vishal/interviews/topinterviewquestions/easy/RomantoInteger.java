package com.vishal.interviews.topinterviewquestions.easy;

import java.util.*;

public class RomantoInteger {

	public static void main(String[] args) {

	}

	// IV - 4
	// VI - 6
	// IXIV - 94
	public int romanToInt(String s) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int res = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			int cur = map.get(s.charAt(i));
			int next = map.get(s.charAt(i + 1));
			if (cur < next) {
				res -= cur;
			} else {
				res += cur;
			}
		}
		res += map.get(s.charAt(s.length() - 1));
		return res;
	}

}

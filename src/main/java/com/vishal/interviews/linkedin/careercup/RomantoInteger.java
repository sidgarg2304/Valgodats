package com.vishal.interviews.linkedin.careercup;

import java.util.*;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomantoInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("XIV"));
	}

	public static int romanToInt(String s) {
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
			int c = map.get(s.charAt(i));
			int n = map.get(s.charAt(i+1));

			if (c < n) {
				res -= c;
			} else {
				res += c;
			}
		}
		
		res += map.get(s.charAt(s.length()-1));
		
		return res;
	}

}

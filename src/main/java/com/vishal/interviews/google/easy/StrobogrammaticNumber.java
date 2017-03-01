package com.vishal.interviews.google.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 246
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * @author vkotha
 *
 */
public class StrobogrammaticNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isStrobogrammaticSimple(String num) {
		for (int i = 0, j = num.length() - 1; i <= j; i++, j--)
			if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
				return false;
		return true;
	}

	public boolean isStrobogrammaticAccepted(String num) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('0', '0');
		map.put('1', '1');
		map.put('8', '8');

		int l = 0, r = num.length() - 1;
		while (l <= r) {
			if (!map.containsKey(num.charAt(l)))
				return false;
			if (map.get(num.charAt(l)) != num.charAt(r))
				return false;
			l++;
			r--;
		}

		return true;
	}

}

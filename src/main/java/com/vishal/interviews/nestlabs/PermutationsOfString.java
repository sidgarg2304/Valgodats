package com.vishal.interviews.nestlabs;

import java.util.*;

/**
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * @author vkotha
 *
 */
public class PermutationsOfString {

	public static void main(String[] args) {

		System.out.println(permutationsOfString("abc"));
	}

	public static List<String> permutationsOfString(String s) {
		List<String> res = new ArrayList<>();

		if (s == null || s.equals("")) {
			res.add("");
			return res;
		}

		String first = s.substring(0, 1);
		String sec = s.substring(1);
		List<String> perms = permutationsOfString(sec);
		
		for (String t : perms) {
			for (int i = 0; i <= t.length(); i++) {
				res.add(t.substring(0, i) + first + t.substring(i));
			}
		}

		return res;
	}

}

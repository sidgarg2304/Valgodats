package com.vishal.interviews.facebook.careercup;

import java.util.*;

public class PermutationsOfString {

	public static void main(String[] args) {

		System.out.println(permutations("abc"));
	}

	static List<String> permutations(String s) {
		List<String> res = new ArrayList<>();

		if (s.length() == 1) {
			res.add(s);
			return res;
		}		

		char c = s.charAt(0);
		List<String> sub = permutations(s.substring(1));
		
		for (String t : sub) {
			for (int i = 0; i <= t.length(); i++) {
				String l = t.substring(0, i);
				String r = t.substring(i);
				res.add(l + ""+c + r);
			}
		}

		return res;
	}

}

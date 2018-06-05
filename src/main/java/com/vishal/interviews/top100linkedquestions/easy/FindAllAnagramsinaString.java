package com.vishal.interviews.top100linkedquestions.easy;

import java.util.*;

public class FindAllAnagramsinaString {

	public static void main(String[] args) {

	}

	public static List<Integer> findAnagrams(String s, String p) {

		List<Integer> res = new ArrayList<>();

		int[] cnt = new int[26];
		for (int i = 0; i < p.length(); i++) {
			cnt[p.charAt(i) - 'a']++;
		}

		int st = 0;
		int en = 0;
		int count = p.length();

		while (en < s.length()) {
			
		}
		
		return res;
	}

}

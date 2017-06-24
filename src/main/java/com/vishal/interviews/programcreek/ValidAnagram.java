package com.vishal.interviews.programcreek;

public class ValidAnagram {

	public static void main(String[] args) {

	}

	public boolean isAnagram(String s, String t) {
		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		int[] cnt = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
			cnt[t.charAt(i) - 'a']--;
		}

		for (int i : cnt) {
			if (i != 0) {
				return false;
			}
		}

		return true;
	}

}

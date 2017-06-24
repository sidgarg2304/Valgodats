package com.vishal.interviews.leetcodereremaining;

import java.util.Arrays;

public class RansomNote {

	public static void main(String[] args) {

	}

	public boolean canConstruct(String ransomNote, String magazine) {

		if (magazine == null) {
			return ransomNote == null;
		}

		if (magazine.length() < ransomNote.length()) {
			return false;
		}

		int[] count = new int[26];
		for (char c : magazine.toCharArray()) {
			count[c - 'a']++;
		}

		for (char c : ransomNote.toCharArray()) {
			if (count[c - 'a'] > 0) {
				count[c - 'a']--;
			} else {
				return false;
			}
		}

		return true;
	}
}

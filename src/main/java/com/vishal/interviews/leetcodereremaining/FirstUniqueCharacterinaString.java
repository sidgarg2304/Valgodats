package com.vishal.interviews.leetcodereremaining;

public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {

	}

	public int firstUniqChar(String s) {
		
		if(s == null || s.length() == 0){
			return 0;
		}

		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (count[c - 'a'] == 1) {
				return i;
			}
		}
		
		return -1;
	}

}

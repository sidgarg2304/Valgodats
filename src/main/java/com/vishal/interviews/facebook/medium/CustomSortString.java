package com.vishal.interviews.facebook.medium;

public class CustomSortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String customSortString(String S, String T) {
		int[] tCount = new int[26];
		for (char c : T.toCharArray()) {
			tCount[c - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : S.toCharArray()) {
			for (int i = 0; i < tCount[c - 'a']; i++) {
				sb.append(c);
			}
			tCount[c - 'a'] = 0;
		}
		
		for(char c = 'a'; c <= 'z'; c++){
			for (int i = 0; i < tCount[c - 'a']; i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}

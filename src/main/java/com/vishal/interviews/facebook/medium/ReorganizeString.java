package com.vishal.interviews.facebook.medium;

public class ReorganizeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reorganizeString(String S) {

		int[] count = new int[26];
		for (char c : S.toCharArray()) {
			count[c - 'a']++;
		}

		int[] valid = new int[26];

		StringBuilder sb = new StringBuilder();
		int pos = 0;
		while (pos < S.length()) {
			int nextCharAtPos = findCharAtPos(S, pos, count, valid);
			if (nextCharAtPos != -1) {
				sb.append((char) (nextCharAtPos + 'a'));
				valid[nextCharAtPos] = pos + 2;
				count[nextCharAtPos]--;
			} else {
				return "";
			}
		}
		return sb.toString();
	}
	
	int findCharAtPos(String S, int pos, int[] count, int[] valid) {

		int maxCnt = 0;
		int charAtPos = -1;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > maxCnt && pos >= valid[i]) {
				maxCnt = count[i];
				charAtPos = i;
			}
		}
		return charAtPos;
	}

}

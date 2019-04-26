package com.vishal.interviews.google.medium;

public class ReorganizeString {

	public static void main(String[] args) {

	}

	public String reorganizeString(String S) {

		StringBuilder sb = new StringBuilder();

		int[] count = new int[26];
		int[] valid = new int[26];

		for (char c : S.toCharArray()) {
			count[c - 'a']++;
		}

		int i = 0;
		while (i < S.length()) {
			int nextChar = findNextChar(count, valid, i);
			if (nextChar == -1) {
				return "";
			}

			sb.append((char) (nextChar + 'a'));
			valid[i] += 2;
			count[i]--;
			i++;
		}
		return sb.toString();
	}

	int findNextChar(int[] count, int[] valid, int pos) {
		int maxCnt = Integer.MIN_VALUE;
		int nextChar = -1;
		for (int i = 0; i < 26; i++) {
			if (count[i] > maxCnt && pos >= valid[i]) {
				maxCnt = count[i];
				nextChar = i;
			}
		}
		return nextChar;
	}

}

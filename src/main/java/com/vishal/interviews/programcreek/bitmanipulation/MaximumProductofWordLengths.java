package com.vishal.interviews.programcreek.bitmanipulation;

public class MaximumProductofWordLengths {

	public static void main(String[] args) {

	}

	public int maxProduct(String[] words) {
		if (words == null || words.length == 0)
			return 0;

		int[] arr = new int[words.length];
		for (int j = 0; j < words.length; j++) {
			for (int i = 0; i < words[j].length(); i++) {
				arr[j] |= (1 << (words[j].charAt(i) - 'a'));
			}
		}

		int res = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((arr[i] & arr[j]) == 0) {
					res = Math.max(res, words[i].length() * words[j].length());
				}
			}
		}

		return res;
	}

}

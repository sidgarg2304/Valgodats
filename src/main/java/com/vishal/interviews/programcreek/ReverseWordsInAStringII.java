package com.vishal.interviews.programcreek;

public class ReverseWordsInAStringII {

	public static void main(String[] args) {

	}

	public void reverseWords(char[] s) {
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			if (s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}
		reverse(s, i, s.length - 1);

		reverse(s, 0, s.length - 1);
	}

	static void reverse(char[] nums, int i, int j) {
		while (i < j) {
			char temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

}

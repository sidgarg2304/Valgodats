package com.vishal.interviews.facebook.medium;

public class ReverseWordsInAStringII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void reverseWords(char[] str) {

		if(str == null || str.length == 0) {
			return;
		}
		
		int st = 0;
		for (int i = 0; i <= str.length; i++) {
			if (i == str.length || str[i] == ' ') {
				reverse(str, st, i - 1);
				st = i + 1;
			}
		}
		reverse(str, 0, str.length - 1);
	}

	void reverse(char[] str, int i, int j) {
		while (i < j) {
			char t = str[i];
			str[i] = str[j];
			str[j] = t;
			i++;
			j--;
		}
	}

}

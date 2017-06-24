package com.vishal.interviews.leetcodereremaining;

public class ReverseWordsinaString {

	public static void main(String[] args) {

		System.out.println(reverseWords("   a   b "));
	}

	public static String reverseWords(String s) {

		if(s == null || s.length() == 0){
			return s;
		}
		s = s.trim();
		char[] arr = s.toCharArray();
		int st = 0;
		for (int i = 0; i <= s.length(); i++) {
			if (i == s.length() || arr[i] == ' ') {
				reverse(arr, st, i - 1);
				st = i + 1;
			}
		}

		reverse(arr, 0, s.length() - 1);
		
		return String.valueOf(arr);
	}

	static void reverse(char[] arr, int i, int j) {
		while (i < j) {
			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
	}

}

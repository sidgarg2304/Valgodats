package com.vishal.interviews.topinterviewquestions.easy;

public class ReverseString {

	public static void main(String[] args) {

	}

	String reverse(String s) {
		char[] a = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			char t = a[i];
			a[i] = a[j];
			a[j] = t;
			i++;
			j--;
		}

		return String.valueOf(a);
	}

}

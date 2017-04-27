package com.vishal.interviews.amazon.qae.easy;

public class ReverseaString {

	public static void main(String[] args) {

	}

	/**
	 * O(N/2)
	 */
	static void reverse(String s) {
		char[] arr = s.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
		}
	}

}

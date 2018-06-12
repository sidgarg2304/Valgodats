package com.vishal.interviews.salesforce;

public class ReverseWordsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseWordsSimple(String s) {
		if (s == null || s.length() == 0) {
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

	void reverse(char[] arr, int i, int j) {
		while (i < j) {
			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
	}

	public String reverseWords(String s) {
		if (s == null)
			return null;

		char[] a = s.toCharArray();
		int n = a.length;

		// step 1. reverse the whole string
		reverse(a, 0, n - 1);
		// step 2. reverse each word
		reverseWords(a, n);
		// step 3. clean up spaces
		return cleanSpaces(a, n);
	}

	void reverseWords(char[] a, int n) {
		int i = 0, j = 0;

		while (i < n) {
			while (i < j || i < n && a[i] == ' ')
				i++; // skip spaces
			while (j < i || j < n && a[j] != ' ')
				j++; // skip non spaces
			reverse(a, i, j - 1); // reverse the word
		}
	}

	// trim leading, trailing and multiple spaces
	String cleanSpaces(char[] a, int n) {
		int i = 0, j = 0;

		while (j < n) {
			while (j < n && a[j] == ' ')
				j++; // skip spaces
			while (j < n && a[j] != ' ')
				a[i++] = a[j++]; // keep non spaces
			while (j < n && a[j] == ' ')
				j++; // skip spaces
			if (j < n)
				a[i++] = ' '; // keep only one space
		}

		return new String(a).substring(0, i);
	}

}

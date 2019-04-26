package com.vishal.interviews.facebook.medium;

public class ReverseWordsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseWords(String s) {

		char[] arr = s.toCharArray();

		// step 1. reverse the whole string
		reverse(arr, 0, s.length() - 1);
		// step 2. reverse each word
		reverseWords(arr, s.length());

		// step 3. clean up spaces
	    return cleanSpaces(arr, s.length());
	}

	void reverseWords(char[] arr, int n) {

		int i = 0; // start of a word
		int j = 0; // end of a word

		while (i < n) {
			// remove spaces before start of the word and stop i at the first
			// char
			// of the word
			while (i < j || (i < n && arr[i] == ' ')) {
				i++;
			}

			// make sure j begins at i and keep moving j until u hit end of the
			// word
			// and the space after it
			while (j < i || (j < n && arr[j] != ' ')) {
				j++;
			}

			// reverse the word
			reverse(arr, i, j - 1);
		}
	}

	void reverse(char[] arr, int i, int j) {
		while (i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
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

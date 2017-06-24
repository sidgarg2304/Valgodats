package com.vishal.interviews.programcreek;

/**
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 *
 */
public class ReverseVowelsofaString {

	public static void main(String[] args) {

		System.out.println(reverseVowels("vise"));
	}

	public static String reverseVowels(String s) {
		String vowels = "aeiouAEIOU";

		int i = 0;
		int j = s.length() - 1;

		char[] arr = s.toCharArray();
		while (i < j) {
			while (i < arr.length && !vowels.contains(String.valueOf(arr[i]))) {
				i++;
			}

			while (j >= 0 && !vowels.contains(String.valueOf(arr[j]))) {
				j--;
			}

			if (i < j) {
				swap(arr, i, j);
			}
			i++;
			j--;
		}

		return String.valueOf(arr);
	}

	static void swap(char[] arr, int i, int j) {
		char t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}

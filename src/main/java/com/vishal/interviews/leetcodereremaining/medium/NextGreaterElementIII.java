package com.vishal.interviews.leetcodereremaining.medium;

/**
 * 556. Next Greater Element III
 * 
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:
Input: 12
Output: 21
Example 2:
Input: 21
Output: -1
 *
 */
public class NextGreaterElementIII {

	public static void main(String[] args) {

		System.out.println(nextGreaterElement(1999999999));
	}

	public static int nextGreaterElement(int n) {
		char[] arr = ("" + n).toCharArray();
		int i = arr.length - 2;

		while (i >= 0 && arr[i] >= arr[i + 1]) {
			i--;
		}
		if (i < 0) {
			return -1;
		}

		int j = arr.length - 1;
		while (arr[j] <= arr[i]) {
			j--;
		}

		swap(arr, i, j);
		reverse(arr, i + 1, arr.length - 1);

		try {
			return Integer.parseInt(String.valueOf(arr));
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	static void swap(char[] arr, int i, int j) {
		char t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	static void reverse(char[] arr, int i, int j) {
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}
}

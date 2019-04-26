package com.vishal.interviews.facebook.medium;

public class NextGreaterElementIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int nextGreaterElement(int n) {

		char[] arr = String.valueOf(n).toCharArray();
		int i = arr.length - 2;

		while (i >= 0 && arr[i] >= arr[i + 1]) {
			i--;
		}
		if (i < 0) {
			return -1;
		}

		int j = arr.length - 1;
		while (j > i && arr[j] <= arr[i]) {
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

	static void reverse(char[] arr, int i, int j) {
		while (i < j) {
			swap(arr, i++, j--);
		}
	}

	static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

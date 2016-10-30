package com.vishal.algorithms.backtracking;

public class BackTrackingAlgorithms {

	public static void main(String[] args) {
		testCanPlayerWin();
	}

	public static void testCanPlayerWin() {

		char [] arr = {'+','+','-','-'};
		System.out.println("first player " + (canPlayerWin(arr) ? "wins" : "does not win"));
	}

	public static boolean canPlayerWin(char[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1] && arr[i] == '+') {
				arr[i] = '-';
				arr[i - 1] = '-';

				boolean canSecPlayerWin = canPlayerWin(arr);

				arr[i] = '+';
				arr[i - 1] = '+';
				
				if (!canSecPlayerWin) {
					return true;
				}
			}
		}

		return false;
	}

}

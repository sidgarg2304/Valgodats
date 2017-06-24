package com.vishal.interviews.programcreek;

public class FlipGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canWin(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		return canWin(s.toCharArray());
	}

	boolean canWin(char[] arr) {

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == '+' && arr[i - 1] == '+') {
				arr[i] = '-';
				arr[i - 1] = '-';
				boolean canSecWin = canWin(arr);
				if (!canSecWin) {
					return true;
				}
				arr[i] = '+';
				arr[i - 1] = '+';
			}
		}
		return false;
	}

}

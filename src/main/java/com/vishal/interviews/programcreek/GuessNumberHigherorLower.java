package com.vishal.interviews.programcreek;

public class GuessNumberHigherorLower {

	public static void main(String[] args) {

	}

	public int guessNumber(int n) {

		int i = 1;
		int j = n;

		while (i <= j) {
			int m = i + (j - i) / 2;
			int g = guess(m);
			if (g == 0) {
				return m;
			} else if (g == -1) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}

		return -1;
	}

	int guess(int val) {
		return 0;
	}

}

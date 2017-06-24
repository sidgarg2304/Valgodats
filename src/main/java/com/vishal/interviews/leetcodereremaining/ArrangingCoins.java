package com.vishal.interviews.leetcodereremaining;

public class ArrangingCoins {

	public static void main(String[] args) {

	}

	public int arrangeCoins(int n) {

		int i = 0;
		int j = n;

		while (i <= j) {
			int m = i + (j - i) / 2;
			double val = (0.5 * m * m) + (0.5 * m);
			if (val < n) {
				i = m + 1;
			} else {
				j = m - 1;
			}
		}

		return i - 1;
	}

}
